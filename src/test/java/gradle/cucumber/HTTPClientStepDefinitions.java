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
  private int DEFAULT_PORT = 3000;

  @Before("not @port5000")
  public void connectClient() {
    client = new HTTPClient(DEFAULT_PORT, HOST);
  }

  @Before("@port5000")
  public void connectClient2() {
    client = new HTTPClient(5000, HOST);
  }

//  @After
//  public void closeClientConnection() {
//    client.closeClient();
//  }

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

  @Given("^I start the server with the option \"([^\"]*)\"$")
  public void iStartTheServerWithTheOption(String option) throws Throwable {
    Runtime.getRuntime().exec("javac -cp src/main/java/StartServer.java");
    Runtime.getRuntime().exec("java -cp src/main/java StartServer " + option);
  }

  @And("^the response header should include \"([^\"]*)\" \"([^\"]*)\"$")
  public void theResponseHeaderShouldInclude(String header, String option) {
    assertTrue(client.getHeaders(header).contains(option));
  }

  @When("^I visit \"([^\"]*)\" and follow the 302 Location$")
  public void iVisitAndFollowTheLocation(String path) throws Throwable {
    client = new HTTPClient(5000, HOST);
    client.createRedirectClient();
    client.redirect(path);
  }

  @And("^the response body contains all of the files and directory contents in \"([^\"]*)\"$")
  public void theResponseBodyContainsAllOfTheFilesAndDirectoryContentsIn(String directory) throws Throwable {
    String htmlDoc = "<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "<head>\n" +
      "    <meta charset=\"UTF-8\">\n" +
      "    <title>Title</title>\n" +
      "</head>\n" +
      "<body>\n" +
      "<ul>\n" +
      "<li><a href=\"/text-file.txt\">text-file.txt</a></li>\n" +
      "<li><a href=\"/file2\">file2</a></li>\n" +
      "<li><a href=\"/image.gif\">image.gif</a></li>\n" +
      "<li><a href=\"/file1\">file1</a></li>\n" +
      "<li><a href=\"/image.png\">image.png</a></li>\n" +
      "</ul>\n" +
      "</body>\n" +
      "</html>";
    String body = client.getResponseBody();
    assertEquals(htmlDoc, body);
  }

  @And("^the response body has directory link \"([^\"]*)\"$")
  public void theResponseBodyHasDirectoryLink(String file) throws Throwable {
    assertTrue(client.getResponseBody().contains("<a href=\"" + file + "\">" + file.substring(1) + "</a>"));
  }

  @And("^I have made additional requests$")
  public void iHaveMadeAdditionalRequests() throws Throwable {
    client = new HTTPClient(DEFAULT_PORT, HOST);
    client.get("/echo");
    client = new HTTPClient(DEFAULT_PORT, HOST);
    client.post("Hello, this is logs", "/echo");
  }

  @When("^I request \"GET\" \"([^\"]*)\" with authorization$")
  public void iRequestWithAuthorization(String path) throws Throwable {
    client.getWithAuth(path);
  }

  @And("^the response body has log contents$")
  public void theResponseBodyHasLogContents() throws Throwable {
    String body = client.getResponseBody();
    assertTrue(body.contains("GET /echo HTTP/1.1"));
    assertTrue(body.contains("POST /echo HTTP/1.1"));
  }
}
