package HttpClient;

import http_server_app.server.Request.Credential;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.io.ByteStreams.toByteArray;
import static gradle.cucumber.StepDefinitionsHelper.parseFormData;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

public class HTTPClient {
  private final int port;
  private final String host;
  private CloseableHttpClient client;
  private CloseableHttpResponse response;
  private HttpPatch httpPatch;
  private HttpRequestBase request;

  public HTTPClient(int port, String host) {
    this.port = port;
    this.host = host;
    this.client = HttpClientBuilder
      .create()
      .disableRedirectHandling()
      .build();
  }

  public void createRedirectClient() {
    this.client = HttpClientBuilder
      .create()
      .setRedirectStrategy(new LaxRedirectStrategy())
      .build();
  }

  private URI uri(String path) throws URISyntaxException {
    return new URIBuilder()
      .setScheme("http")
      .setHost(host)
      .setPort(port)
      .setPath(path)
      .build();
  }

  public void get(String path) throws URISyntaxException {
    request = new HttpGet(uri(path));
  }

  public void getWithAuth(String path) throws URISyntaxException {
    HttpGet httpGet = new HttpGet(uri(path));
    Credential credential = new Credential("one", "two");
    httpGet.setHeader(AUTHORIZATION, "Basic " + credential.encode());
    try {
      response = client.execute(httpGet);
    } catch (IOException e) {
      retryRequest(httpGet);
    }
  }

  public void post(String body, String path) throws URISyntaxException, UnsupportedEncodingException {
    HttpPost httpPost = new HttpPost(uri(path));
    httpPost.setEntity(new StringEntity(body));
    request = httpPost;
  }

  private void options(String path) throws URISyntaxException {
    request = new HttpOptions(uri(path));
  }

  private void put(String body, String path) throws URISyntaxException {
    HttpPut httpPut = new HttpPut(uri(path));
    List<NameValuePair> formParams = new ArrayList<>();
    formParams.add(new BasicNameValuePair(parseFormData(body)[0], parseFormData(body)[1]));
    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
    httpPut.setEntity(entity);
    request = httpPut;
  }

  private void head(String path) throws URISyntaxException {
    request = new HttpHead(uri(path));
  }

  private void delete(String path) throws URISyntaxException {
    request = new HttpDelete(uri(path));
  }


  private void invalid(String method, String path) throws URISyntaxException {
    request = new InvalidRequest(method, uri(path).toString());
  }

  private void patch(String content, String path) throws URISyntaxException, UnsupportedEncodingException {
    httpPatch = new HttpPatch(uri(path));
    httpPatch.setEntity(new StringEntity(content));
    request =  httpPatch;
  }

  public void setEtag(String etag) {
    httpPatch.setHeader("ETag", etag);
    request = httpPatch;
  }

  public void requestWithRange(String path, String range) throws URISyntaxException {
    HttpGet httpGet = new HttpGet(uri(path));
    httpGet.setHeader("Content-Range", range);
    try {
      response = client.execute(httpGet);
    } catch (IOException e) {
      retryRequest(httpGet);
    }
  }

  public void redirect(String path) throws URISyntaxException {
    HttpClientContext context = HttpClientContext.create();
    HttpGet httpGet = new HttpGet(uri(path));
    makeRequestWithContext(httpGet, context);
    HttpHost target = context.getTargetHost();

    List<URI> redirectLocations = context.getRedirectLocations();
    URI location = URIUtils.resolve(httpGet.getURI(), target, redirectLocations);

    System.out.println("Executing request " + httpGet.getRequestLine());
    System.out.println("----------------------------------------");
    System.out.println("Final HTTP location: " + location.toASCIIString());
  }

  public void makeRequest(String method, String path) throws URISyntaxException {
    switch (method) {
      case "GET":
        get(path);
        break;
      case "OPTIONS":
        options(path);
        break;
      case "HEAD":
        head(path);
        break;
      case "DELETE":
        delete(path);
        break;
      default:
        invalid(method, path);
        break;
    }
    try {
      response = client.execute(request);
    } catch (IOException e) {
      retryRequest(request);
    }
  }

  public void makeRequest(String method, String path, String body) throws URISyntaxException, UnsupportedEncodingException {
    switch (method) {
      case "POST":
        post(body, path);
        break;
      case "PUT":
        put(body, path);
        break;
      case "PATCH":
        patch(body, path);
        break;
    }
    try {
      response = client.execute(request);
    } catch (IOException e) {
      retryRequest(request);
    }
  }

  public void retryRequest(HttpRequestBase request) {
    try {
      Thread.sleep(1000);
      response = client.execute(request);
    } catch (IOException | InterruptedException e1) {
      try {
        Thread.sleep(3000);
        response = client.execute(request);
      } catch (IOException | InterruptedException e2) {
        e2.printStackTrace();
      }
    }
  }

  private void makeRequestWithContext(HttpRequestBase request, HttpClientContext context) {
    try {
      response = client.execute(request, context);
    } catch (IOException e) {
      try {
        Thread.sleep(1000);
        response = client.execute(request, context);
      } catch (IOException | InterruptedException e1) {
        try {
          Thread.sleep(3000);
          response = client.execute(request, context);
        } catch (IOException | InterruptedException e2) {
          e2.printStackTrace();
        }
      }
    }
  }

  public String getResponseBody() throws IOException {
private    HttpEntity entity = response.getEntity();
    byte[] responseBody = new byte[0];
    if (entity != null) {
      responseBody = toByteArray(entity.getContent());
    }
    return new String(responseBody);
  }

  public int getResponseStatusCode() {
    return response.getStatusLine().getStatusCode();
  }

  public Set<String> getHeaders(String headerName) {
    HeaderIterator it = response.headerIterator(headerName);
    Set<String> headerValues = new HashSet<>();
    while (it.hasNext()) {
      Header header = it.nextHeader();
      HeaderElement[] elements = header.getElements();
      for (HeaderElement element : elements) {
        headerValues.add(element.getName());
      }
    }
    return headerValues;
  }
}
