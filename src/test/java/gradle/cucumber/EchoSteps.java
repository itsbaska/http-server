package gradle.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.*;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static gradle.cucumber.StepDefinitionsHelper.parseFormData;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EchoSteps {
  private CloseableHttpClient httpclient;
  private CloseableHttpResponse response;
  private HttpGet httpGet;
  private static int DEFAULT_PORT = 3000;
  private static String HOST = "127.0.0.1";

  @Given("the server is running")
  public void serverIsRunning() {
  }

  @Given("^I am in a console shell$")
  public void iAmInAConsoleShell() {
  }

  @When("^I \"POST\" \"([^\"]*)\" to \"([^\"]*)\"$")
  public void iPostTo(String body, String path) throws Throwable {
    httpclient = HttpClients.createDefault();
    URI uri = new URIBuilder()
      .setScheme("http")
      .setHost(HOST)
      .setPort(DEFAULT_PORT)
      .setPath(path)
      .build();

    HttpPost httpPost = new HttpPost(uri);
    httpPost.setEntity(new StringEntity(body));
    response = httpclient.execute(httpPost);
  }

  @When("^I request \"GET\" \"([^\"]*)\"$")
  public void iRequest(String path) throws Throwable {
    httpclient = HttpClients.createDefault();
    URI uri = new URIBuilder()
      .setScheme("http")
      .setHost(HOST)
      .setPort(DEFAULT_PORT)
      .setPath(path)
      .build();
    httpGet = new HttpGet(uri);
    response = httpclient.execute(httpGet);
  }

  @When("^I \"PUT\" \"([^\"]*)\" to \"([^\"]*)\"$")
  public void iPutTo(String body, String path) throws Throwable {
    httpclient = HttpClients.createDefault();
    URI uri = new URIBuilder()
      .setScheme("http")
      .setHost(HOST)
      .setPort(DEFAULT_PORT)
      .setPath(path)
      .build();

    HttpPut httpPut = new HttpPut(uri);
    List<NameValuePair> formParams = new ArrayList<>();
    formParams.add(new BasicNameValuePair(parseFormData(body)[0], parseFormData(body)[1]));
    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
    httpPut.setEntity(entity);
    response = httpclient.execute(httpPut);
  }

  @When("^I start the server with the option \"([^\"]*)\"$")
  public void iStartTheServerWithTheOption(String option) throws Throwable {
    Runtime.getRuntime().exec("javac -cp src/main/java/StartServer.java");
    Runtime.getRuntime().exec("java -cp src/main/java StartServer " + option);
  }


  @When("^I request \"OPTIONS\" \"([^\"]*)\"$")
  public void iRequestOptions(String path) throws Throwable {
    httpclient = HttpClients.createDefault();
    URI uri = new URIBuilder()
      .setScheme("http")
      .setHost(HOST)
      .setPort(DEFAULT_PORT)
      .setPath(path)
      .build();
      HttpOptions httpOptions = new HttpOptions(uri);
    response = httpclient.execute(httpOptions);
  }

  @Then("^the response status should be (\\d+)$")
  public void theResponseStatusShouldBe(int status) {
    assertEquals(status, response.getStatusLine().getStatusCode());
  }
  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();


  @And("the response body should be empty")
  public void theResponseBodyShouldBeEmpty()  throws Throwable {
    String responseBody;
    try {
      responseBody = new BasicResponseHandler().handleResponse(response);
    } catch (HttpResponseException e) {
      System.err.println(e.getMessage());
      responseBody = e.getMessage();
    }
    assertEquals("", responseBody);
  }

  @And("^the response body should be \"([^\"]*)\"$")
  public void theResponseBodyShouldBe(String responseBody) throws IOException {
    String responseBody1;
    responseBody1 = new BasicResponseHandler().handleResponse(response);
    assertEquals(responseBody, responseBody1);
  }

  @And("^the response header should include \"Allow\" \"([^\"]*)\"$")
  public void theResponseHeaderShouldInclude(String option) {
    HeaderIterator it = response.headerIterator("Allow");
    Set<String> methods = new HashSet<>();
    while (it.hasNext()) {
      Header header = it.nextHeader();
      HeaderElement[] elements = header.getElements();
      for (HeaderElement element : elements) {
        methods.add(element.getName());
      }
    }
    assertTrue(methods.contains(option));
  }

  @And("^I request \"GET\" \"([^\"]*)\" on port \"([^\"]*)\"$")
  public void iRequestOnPort(String path, String port) throws Throwable {
    httpclient = HttpClients.createDefault();
    URI uri = new URIBuilder()
      .setScheme("http")
      .setHost(HOST)
      .setPort(Integer.parseInt(port))
      .setPath(path)
      .build();
    httpGet = new HttpGet(uri);
    response = httpclient.execute(httpGet);
  }
}
