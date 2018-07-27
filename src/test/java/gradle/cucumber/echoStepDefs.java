package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Request.*;
import Response.Response;
import testClient.TestClient;

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
  public void iTo(String method, String body, String path) throws Throwable {
    testClient = new TestClient();
    String request = new Post(path, body).request();
    testClient.sendRequest(request);
  }

  @When("^I request \"([^\"]*)\" \"([^\"]*)\"$")
  public void iRequest(String method, String path) throws Throwable {
    testClient = new TestClient();
    String request = new Get(path).request();
    testClient.sendRequest(request);
  }

  @Then("the response body should be empty")
  public void the_response_body_should_be_empty() throws IOException {
    testClient.closeSocket();
    assertEquals("", response.body());
  }

  @Then("^the response status should be (\\d+)$")
  public void theResponseStatusShouldBe(int status) throws Throwable {
    System.out.println("Before getting res");
    String clientResponse = testClient.getResponse();

    System.out.println(clientResponse);
    response = new Response(clientResponse);
    assertEquals(status, Integer.parseInt(response.status()));
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
