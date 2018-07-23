package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Request.Request;
import server.Server;

public class echoStepDefs {
  @Given("the server is running")
  public void serverIsRunning() {
    Server server = new Server();
    server.createSocket();
  }

  @When("I request {string} {string}")

  public void i_request(String method, String path) {
    Request request = new Request();
    request.requestGet(method, path);
  }

  @When("I {string} {string} to {string}")
  public void i_to(String string, String string2, String string3) {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("the response status should be {int}")
  public void the_response_status_should_be() {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("the response body should be empty")
  public void the_response_body_should_be_empty() {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
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
