package gradle.cucumber;

import Response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import testClient.TestClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Request.*;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class echoStepDefs {
  private TestClient testClient;
  private Response response;

  @Given("the server is running")
  public void serverIsRunning() throws IOException {
    boolean result = false;
    try {
      (new Socket("127.0.0.1", 3000)).close();
      result = true;
    } catch(SocketException e) {
      System.out.println(e);
    }
    assertTrue(result);
  }

  @When("^I \"([^\"]*)\" \"([^\"]*)\" to \"([^\"]*)\"$")
  public void iTo(String method, String data, String path) throws Throwable {
    testClient = new TestClient();
    String request = new PostRequest().make(path, data);
    testClient.sendRequest(request);
  }

  @When("^I request \"([^\"]*)\" \"([^\"]*)\"$")
  public void iRequest(String method, String path) throws Throwable {
    testClient = new TestClient();
    String request = new GetRequest().make();
    testClient.sendRequest(request);
  }

  @Then("the response body should be empty")
  public void the_response_body_should_be_empty() throws IOException {
    testClient.closeSocket();
    assertEquals("", response.body());
  }

  @Then("^the response status should be (\\d+)$")
  public void theResponseStatusShouldBe(int status) throws Throwable {
    response = new Response(testClient.getResponse());
    String responseStatus = response.status();
    assertEquals(status, Integer.parseInt(responseStatus));
  }

  @And("^the response body should be \"([^\"]*)\"$")
  public void theResponseBodyShouldBe(String responseBody)  {
    try {
      testClient.closeSocket();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals(responseBody, response.body());
  }
}
