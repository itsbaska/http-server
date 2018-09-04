package HttpClient;

import Request.Credential;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
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
  private HttpGet httpGet;

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

  public void get(String path) throws IOException, URISyntaxException {
    httpGet = new HttpGet(uri(path));
    response = client.execute(httpGet);
  }

  public void getWithAuth(String path) throws URISyntaxException, IOException {
    httpGet = new HttpGet(uri(path));
    Credential credential = new Credential("one", "two");
    httpGet.setHeader(AUTHORIZATION, "Basic " + credential.encode());
    response = client.execute(httpGet);
  }

  public void post(String body, String path) throws IOException, URISyntaxException {
    HttpPost httpPost = new HttpPost(uri(path));
    httpPost.setEntity(new StringEntity(body));
    response = client.execute(httpPost);
  }

  public void options(String path) throws IOException, URISyntaxException {
    HttpOptions httpOptions = new HttpOptions(uri(path));
    response = client.execute(httpOptions);
  }

  public void put(String body, String path) throws IOException, URISyntaxException {
    HttpPut httpPut = new HttpPut(uri(path));
    List<NameValuePair> formParams = new ArrayList<>();
    formParams.add(new BasicNameValuePair(parseFormData(body)[0], parseFormData(body)[1]));
    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
    httpPut.setEntity(entity);
    response = client.execute(httpPut);
  }

  public void head(String path) throws IOException, URISyntaxException {
    HttpHead httpHead = new HttpHead(uri(path));
    response = client.execute(httpHead);
  }

  public void delete(String path) throws URISyntaxException, IOException {
    HttpDelete httpDelete = new HttpDelete(uri(path));
    response = client.execute(httpDelete);
  }


  public void invalid(String method, String path) throws IOException, URISyntaxException {
    InvalidRequest request = new InvalidRequest(method, uri(path).toString());
    response = client.execute(request);
  }

  public void requestWithRange(String path, String range) throws URISyntaxException, IOException {
    httpGet = new HttpGet(uri(path));
    httpGet.setHeader("Content-Range", range);
    response = client.execute(httpGet);
  }

  public void redirect(String path) throws IOException, URISyntaxException {
    HttpClientContext context = HttpClientContext.create();
    HttpGet httpGet = new HttpGet(uri(path));

    response = client.execute(httpGet, context);
    HttpHost target = context.getTargetHost();

    List<URI> redirectLocations = context.getRedirectLocations();
    URI location = URIUtils.resolve(httpGet.getURI(), target, redirectLocations);

    System.out.println("Executing request " + httpGet.getRequestLine());
    System.out.println("----------------------------------------");
    System.out.println("Final HTTP location: " + location.toASCIIString());
  }

  public String getResponseBody() throws IOException {
    HttpEntity entity = response.getEntity();
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

  public void closeClient() {
    HttpClientUtils.closeQuietly(client);
  }
}
