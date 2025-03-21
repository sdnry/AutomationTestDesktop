package com.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the page object for an example scenario, which appears to be a login page.
 * It encapsulates the elements and actions related to user authentication.
 *
 * Elements included in this page:
 * - Username input field identified by "user-name".
 * - Password input field identified by "password".
 * - Login button identified by "login-button".
 * - Shop page container identified by "inventory_container", used to verify successful login.
 *
 * The class uses Selenium's PageFactory to initialize web elements.
 *
 * Provided methods:
 * - enterUsername(String username): Enters the provided username into the username field.
 * - enterPassword(String password): Enters the provided password into the password field.
 * - clickOnLoginBtn(): Clicks the login button.
 * - checkIfUserIsLogged(): Asserts that the shop page container is displayed, indicating a successful login.
 */
public class ExampleScenarioPage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(id = "inventory_container")
    private WebElement shopPage;

    public ExampleScenarioPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    public void checkIfUserIsLogged() {
        assert shopPage.isDisplayed();
    }

}
