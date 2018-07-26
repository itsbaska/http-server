package gradle.cucumber;

import Response.Response;
import testClient.TestClient;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Request.*;
import server.Server;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class echoStepDefs {
  private Server server;
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

  @When("I request {string} {string}")
  public void i_request(String method, String path) throws IOException {
    testClient = new TestClient();
    String request = new GetRequest().make();
    testClient.sendRequest(request);
  }

  @Then("the response status should be {int}")
  public void the_response_status_should_be(int status) throws IOException {
    response = new Response(testClient.getResponse());
    String responseStatus = response.status();
    assertEquals(status, Integer.parseInt(responseStatus));
  }

  @Then("the response body should be empty")
  public void the_response_body_should_be_empty() throws IOException {
    testClient.closeSocket();
    assertEquals("", response.body());

  }

  //  Given the server is running
//  When I "POST" "hello" to "/echo"
//  Then the response status should be 200
//  And the response body should be "hello"


  @When("I {string} {string} to {string}")
  public void i_to(String method, String data, String path) throws IOException {
    testClient = new TestClient();
    String request = new PostRequest().make(path, data);
    testClient.sendRequest(request);
  }

  @When("I \"POST\" \"hello\" to \"/echo\"")
  public void i_post_hello(String path, String data) throws IOException {
    testClient = new TestClient();
    String request = new PostRequest().make(path, data);
    testClient.sendRequest(request);
  }

  @When("I \"POST\" \"goodbye\" to \"/echo\"")
  public void i_post_goodbye(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("the response body should be \"hello\"")
  public void the_response_body_should_be_hello() throws IOException {
    try {
      testClient.closeSocket();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("hello", response.body());
  }

  @Then("the response body should be \"goodbye\"")
  public void the_response_body_should_be_goodbye() {
    try {
      testClient.closeSocket();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("goodbye", response.body());
  }
}
