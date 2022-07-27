package abstractions.stepDefinitions;

import abstractions.helpers.AbstractHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class SearchStepDefinitions extends AbstractHelper{

    @Given("^Navigate to Apple's site$")
    public void should_logged_in(){

    }

    @And("search for product or item {string} in search bar")
    public void searchForProductOrItemInSearchBar(String arg0) {
    }

    @And("Verify Search executed")
    public void verifySearchExecuted() {
    }

    @When("Click first result in results")
    public void clickFirstResultInResults() {
    }

    @Then("Verify expected item page opened")
    public void verifyExpectedItemPageOpened() {
    }
}