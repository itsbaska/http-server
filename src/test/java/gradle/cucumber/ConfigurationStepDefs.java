package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ConfigurationStepDefs {
  @Given("^I am in a console shell$")
  public void iAmInAConsoleShell() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^I start the server with the option \"([^\"]*)\"$")
  public void iStartTheServerWithTheOption(String arg0) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @And("^I request \"([^\"]*)\" \"([^\"]*)\" on port \"([^\"]*)\"$")
  public void iRequestOnPort(String arg0, String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
}
