package gradle.cucumber;

import HttpClient.HTTPClient;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HTTPClientStepDefinitions {
  private static String HOST = "127.0.0.1";
  private HTTPClient client;

  @Before
  public void connectClient() {
    int DEFAULT_PORT = 3000;
    client = new HTTPClient(DEFAULT_PORT, HOST);
  }

  @Given("the server is running")
  public void serverIsRunning() {
  }

  @And("^I request \"GET\" \"([^\"]*)\" on port \"([^\"]*)\"$")
  public void iRequestOnPort(String path, String port) throws Throwable {
    client = new HTTPClient(Integer.parseInt(port), HOST);
    client.get(path);
  }

  @When("^I request \"GET\" \"([^\"]*)\"$")
  public void iRequest(String path) throws Throwable {
    client.get(path);
  }

  @When("^I \"POST\" \"([^\"]*)\" to \"([^\"]*)\"$")
  public void iPostTo(String body, String path) throws Throwable {
    client.post(body, path);
  }

  @When("^I \"PUT\" \"([^\"]*)\" to \"([^\"]*)\"$")
  public void iPutTo(String body, String path) throws Throwable {
    client.put(body, path);
  }

  @When("^I request \"OPTIONS\" \"([^\"]*)\"$")
  public void iRequestOptions(String path) throws Throwable {
    client.options(path);
  }

  @When("^I request \"HEAD\" \"([^\"]*)\"$")
  public void iRequestHead(String path) throws Throwable {
    client.head(path);
  }

  @Then("^the response status should be (\\d+)$")
  public void theResponseStatusShouldBe(int status) {
    assertEquals(status, client.getResponseStatusCode());
  }

  @And("^the response body should be \"([^\"]*)\"$")
  public void theResponseBodyShouldBe(String responseBody) throws IOException {
    assertEquals(responseBody, client.getResponseBody());
  }

  @And("the response body should be empty")
  public void the_response_body_should_be_empty() throws IOException {
    assertEquals("", client.getResponseBody());
  }

  @Given("^I am in a console shell$")
  public void iAmInAConsoleShell() {
  }

  @When("^I start the server with the option \"([^\"]*)\"$")
  public void iStartTheServerWithTheOption(String option) throws Throwable {
    Runtime.getRuntime().exec("javac -cp src/main/java/StartServer.java");
    Runtime.getRuntime().exec("java -cp src/main/java StartServer " + option);
  }

  @And("^the response header should include \"([^\"]*)\" \"([^\"]*)\"$")
  public void theResponseHeaderShouldInclude(String header, String option) {
    assertTrue(client.getHeaders(header).contains(option));
  }
}
