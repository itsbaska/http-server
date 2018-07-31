package gradle.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EchoSteps {
  private CloseableHttpClient httpclient;
  private CloseableHttpResponse response;
  private HttpGet httpGet;
  private HttpPost httpPost;
  private static int DEFAULT_PORT = 3000;

  private static boolean serverIsRunning(int port) throws IOException {
    boolean result = false;
    try {
      (new Socket("127.0.0.1", port)).close();
      result = true;
    } catch (SocketException e) {
      System.out.println(e);
    }
    return result;
  }

  @Given("the server is running")
  public void serverIsRunning() throws IOException {
    Runtime.getRuntime()
    .exec("javac -cp src/main/java/StartServer.java && java -cp src/main/java StartServer -p " +  Integer.toString(DEFAULT_PORT));
    assertTrue(serverIsRunning(DEFAULT_PORT));
  }

  @When("^I \"POST\" \"([^\"]*)\" to \"([^\"]*)\"$")
  public void iTo(String body, String path) throws Throwable {
    httpclient = HttpClients.createDefault();
    httpPost = new HttpPost("http://localhost:" + Integer.toString(DEFAULT_PORT) + path);
    response = httpclient.execute(httpPost);
    httpPost.setEntity(new StringEntity(body));
    CloseableHttpResponse response = httpclient.execute(httpPost);
    try {
      HttpEntity entity2 = response.getEntity();
      EntityUtils.consume(entity2);
    } finally {
      response.close();
    }
  }

  @When("^I request \"GET\" \"([^\"]*)\"$")
  public void iRequest(String path) throws Throwable {
    httpclient = HttpClients.createDefault();
    httpGet = new HttpGet("http://localhost:" + Integer.toString(DEFAULT_PORT) + path);
    response = httpclient.execute(httpGet);
  }

  @And("the response body should be empty")
  public void the_response_body_should_be_empty() throws IOException {
    String responseBody;
    try {
      HttpEntity entity = response.getEntity();
      EntityUtils.consume(entity);
      ResponseHandler<String> handler = new BasicResponseHandler();
      responseBody = httpclient.execute(httpGet, handler);
    } finally {
      response.close();
    }
    assertEquals("", responseBody);
  }

  @Then("^the response status should be (\\d+)$")
  public void theResponseStatusShouldBe(int status) throws Throwable {
    assertEquals(status, response.getStatusLine().getStatusCode());
  }

  @And("^the response body should be \"([^\"]*)\"$")
  public void theResponseBodyShouldBe(String responseBody) throws IOException {
    String responseBody1;
    try {
      HttpEntity entity = response.getEntity();
      EntityUtils.consume(entity);
      ResponseHandler<String> handler = new BasicResponseHandler();
      responseBody1 = httpclient.execute(httpPost, handler);
    } finally {
      response.close();
    }
    assertEquals(responseBody, responseBody1);
  }

  @Given("^I am in a console shell$")
  public void iAmInAConsoleShell() throws Throwable {
    Runtime.getRuntime()
    .exec("javac -cp src/main/java/StartServer.java ");
  }

  @When("^I start the server with the option \"([^\"]*)\"$")
  public void iStartTheServerWithTheOption(String option) throws Throwable {
    Runtime.getRuntime()
    .exec("java -cp src/main/java StartServer " + option);
  }

  @And("^I request \"GET\" \"([^\"]*)\" on port \"([^\"]*)\"$")
  public void iRequestOnPort(String path, String port) throws Throwable {
    httpclient = HttpClients.createDefault();
    httpGet = new HttpGet("http://127.0.0.1:" + port + path);
    response = httpclient.execute(httpGet);
  }
}
