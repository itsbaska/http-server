package gradle.cucumber;

import http_server_app.application.config.Config;
import http_server_app.server.Directory.FileHandler;
import HttpClient.HTTPClient;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.Runtime.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HTTPClientStepDefinitions {
  private static String HOST = "127.0.0.1";
  private HTTPClient client;
  private int DEFAULT_PORT = 3000;
  private static boolean serverIsRunning = false;

  @Before("not @port5000")
  public void connectClient() {
    client = new HTTPClient(DEFAULT_PORT, HOST);
  }

  @Before("@port5000")
  public void connectClient2() {
    client = new HTTPClient(5000, HOST);
  }

  @Given("the server is running")
  public void serverIsRunning() {
  }

  @Given("^the page content of \"([^\"]*)\" is empty$")
  public void thePageContentOfIsEmpty(String path) throws Throwable {
    client.makeRequest("GET", path);
    assertEquals(client.getResponseBody(), "");
  }

  @Given("^I am in a console shell$")
  public void iAmInAConsoleShell() {
  }

  @Given("^I start the server with the option \"([^\"]*)\"$")
  public void iStartTheServerWithTheOption(String option) {
    if (!serverIsRunning) {
      getRuntime().addShutdownHook(new Thread(() -> {
        serverIsRunning = false;
      }));
      try {
        getRuntime().exec("java -jar ./build/libs/http-server-all.jar " + option);
        serverIsRunning = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @And("^I request \"([^\"]*)\" \"([^\"]*)\" on port \"([^\"]*)\"$")
  public void iRequestOnPort(String method, String path, String port) throws Throwable {
    client = new HTTPClient(Integer.parseInt(port), HOST);
    client.makeRequest(method, path);
  }

  @When("^I \"([^\"]*)\" \"([^\"]*)\" to \"([^\"]*)\"$")
  public void iRequestTo(String method, String body, String path) throws Throwable {
    client.makeRequest(method, path, body);
  }

  @When("^I request \"([^\"]*)\" \"([^\"]*)\"$")
  public void iRequest(String method, String path) throws Throwable {
    client.makeRequest(method, path);
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
  public void theResponseBodyShouldBeEmpty() throws IOException {
    assertEquals("", client.getResponseBody());
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
    String body = client.getResponseBody();
    assertTrue(body.contains("text-file.txt"));
    assertTrue(body.contains("file1"));
    assertTrue(body.contains("file2"));
    assertTrue(body.contains("patch-content.txt"));
    assertTrue(body.contains("image.gif"));
    assertTrue(body.contains("image.jpeg"));
    assertTrue(body.contains("image.png"));
    assertTrue(body.contains("partial_content.txt"));
  }

  @And("^the response body has directory link \"([^\"]*)\"$")
  public void theResponseBodyHasDirectoryLink(String file) throws Throwable {
    assertTrue(client.getResponseBody().contains("<a href=\"" + file + "\">" + file.substring(1) + "</a>"));
  }

  @And("^I have made additional requests$")
  public void iHaveMadeAdditionalRequests() throws Throwable {
    client = new HTTPClient(DEFAULT_PORT, HOST);
    client.makeRequest("GET","/echo");
    client = new HTTPClient(DEFAULT_PORT, HOST);
    client.makeRequest("POST", "/echo","Hello, this is logs");
  }

  @When("^I request \"GET\" \"([^\"]*)\" with authorization$")
  public void iRequestWithAuthorization(String path) throws Throwable {
    client = new HTTPClient(DEFAULT_PORT, HOST);
    client.getWithAuth(path);
  }

  @And("^the response body has log contents$")
  public void theResponseBodyHasLogContents() throws Throwable {
    String body = client.getResponseBody();
    assertTrue(body.contains("GET /echo HTTP/1.1"));
    assertTrue(body.contains("POST /echo HTTP/1.1"));
  }

  @Then("^the response body should include \"([^\"]*)\"$")
  public void theResponseBodyShouldInclude(String parameter) throws Throwable {
    assertTrue(client.getResponseBody().contains(parameter));
  }

  @Then("^the response body has file contents \"([^\"]*)\"$")
  public void theResponseBodyHasFileContents(String file) throws Throwable {
    FileHandler fileHandler = new FileHandler(new File(Config.publicDirectory.getPath() + file));
    assertEquals(client.getResponseBody(), new String(fileHandler.readContent()));
  }

  @And("^the file content is set back to \"([^\"]*)\"$")
  public void theFileContentIsSetBackTo(String defaultContent) throws Throwable {
    assertTrue(client.getResponseBody().contains(defaultContent));
  }

  @And("^I set the etag to \"([^\"]*)\"$")
  public void iSetTheEtagTo(String etag) {
    client.setEtag(etag);
  }

  @And("^\"([^\"]*)\" has original contents \"([^\"]*)\"$")
  public void hasOriginalContents(String fileName, String content) throws Throwable {
    FileHandler file = new FileHandler(new File(Config.publicDirectory.getPath() + "/" + fileName));
    assertEquals(content, new String(file.readContent()));
  }

  @And("^I specify a range \"([^\"]*)\"$")
  public void iSpecifyARange(String range) throws URISyntaxException {
    client.requestWithRange("/partial_content.txt", range);
  }

  @And("^the body should include partial contents from (\\d+) to (\\d+)$")
  public void theBodyShouldIncludePartialContentsFromRange_startToRange_end(int start, int end) throws Throwable {
    FileHandler fileHandler = new FileHandler(new File(Config.publicDirectory.getPath() + "/partial_content.txt"));
    String partialContent = new String(fileHandler.readContent()).substring(start, end);
    assertEquals(client.getResponseBody(), partialContent);
  }
}
