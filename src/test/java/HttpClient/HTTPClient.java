package HttpClient;

import org.apache.http.*;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static gradle.cucumber.StepDefinitionsHelper.parseFormData;

public class HTTPClient {
  private final int port;
  private final String host;
  private final CloseableHttpClient client;
  private CloseableHttpResponse response;

  public HTTPClient(int port, String host) {
    this.port = port;
    this.host = host;
    this.client = HttpClientBuilder.create().disableRedirectHandling().build();
  }

  private URI uri(String path) throws URISyntaxException {
    return new URIBuilder()
      .setScheme("http")
      .setHost(host)
      .setPort(port)
      .setPath(path)
      .build();
  }

  public CloseableHttpResponse get(String path) throws IOException, URISyntaxException {
    HttpGet httpGet = new HttpGet(uri(path));
    return response = client.execute(httpGet);
  }

  public CloseableHttpResponse post(String body, String path) throws IOException, URISyntaxException {
    HttpPost httpPost = new HttpPost(uri(path));
    httpPost.setEntity(new StringEntity(body));
    return response = client.execute(httpPost);
  }

  public CloseableHttpResponse options(String path) throws IOException, URISyntaxException {
    HttpOptions httpOptions = new HttpOptions(uri(path));
    return response = client.execute(httpOptions);
  }

  public CloseableHttpResponse put(String body, String path) throws IOException, URISyntaxException {
    HttpPut httpPut = new HttpPut(uri(path));
    List<NameValuePair> formParams = new ArrayList<>();
    formParams.add(new BasicNameValuePair(parseFormData(body)[0], parseFormData(body)[1]));
    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
    httpPut.setEntity(entity);
    return response = client.execute(httpPut);
  }
  public CloseableHttpResponse head(String path) throws IOException, URISyntaxException {
    HttpHead httpHead = new HttpHead(uri(path));
    return response = client.execute(httpHead);
  }
  public String getResponseBody() throws IOException {
    String responseBody;
    try {
      responseBody = new BasicResponseHandler().handleResponse(response);
      if (responseBody == null) {
        responseBody = "";
      }
    } catch (HttpResponseException e) {
      System.err.println(e.getMessage());
      responseBody = e.getMessage();
    }
    return responseBody;
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
