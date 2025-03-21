package com.automation.stepdefinitions;

import com.automation.page.ExampleScenarioPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * This class contains the Cucumber step definitions for an example scenario.
 *
 * It interacts with the web application through the ExampleScenarioPage page object.
 * The WebDriver instance is obtained from the Hooks class.
 *
 * Step definitions include:
 * - Navigating to a given homepage URL.
 * - Entering a username.
 * - Entering a password.
 * - Clicking on the login button.
 * - Verifying that the user is logged in by checking the presence of the shop page.
 *
 * Each method is annotated with the appropriate Cucumber annotations (@Given, @When, @And, @Then)
 * to map feature file steps to Java code.
 */
public class ExampleScenarioStep {

    WebDriver driver = Hooks.driver;

    ExampleScenarioPage exampleScenarioPage = new ExampleScenarioPage(driver);

    @Given("I am on the homepage {string}")
    public void iAmOnTheHomepage(String url) {
        driver.get(url);
    }

    @When("I enter the username {string}")
    public void iEnterTheUsername(String username) {
        exampleScenarioPage.enterUsername(username);
    }

    @And("I enter the known password {string}")
    public void iEnterTheKnownPassword(String password) {
        exampleScenarioPage.enterPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        exampleScenarioPage.clickOnLoginBtn();
    }

    @Then("I am logged on the shop")
    public void iAmLoggedOnTheShop() {
        exampleScenarioPage.checkIfUserIsLogged();
    }
}

