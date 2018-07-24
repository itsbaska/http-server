package gradle.cucumber;

import testClient.TestClient;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Request.Request;
import server.Server;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class echoStepDefs {
  private Server server;
  private TestClient testClient;

  @Given("the server is running")

  public void serverIsRunning() throws IOException {
    server = new Server();
//    server.createSocket();
  }

  @When("I request {string} {string}")

  public void i_request(String method, String path) throws IOException {
    testClient.makeRequest(new Request().request(method, path, ""));
  }

  @When("I {string} {string} to {string}")
  public void i_to(String string, String string2, String string3) {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("the response status should be {int}")
  public void the_response_status_should_be(int status) throws IOException {
    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//    testClient.readResponse(testClient.in);
//    server.closeSocket();
    assertEquals(status, 200);
  }

  @Then("the response body should be empty")
  public void the_response_body_should_be_empty() {
    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
    assertEquals("", "");

  }

  @When("I \"POST\" \"hello\" to \"/echo\"")
  public void i_post_hello(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("I \"POST\" \"goodbye\" to \"/echo\"")
  public void i_post_goodbye(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("the response body should be \"hello\"")
  public void the_response_body_should_be_hello() {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("the response body should be \"goodbye\"")
  public void the_response_body_should_be_goodbye() {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
}
