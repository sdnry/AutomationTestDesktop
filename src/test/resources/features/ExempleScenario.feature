Feature: Download page on Selenium website
  Scenario: Perform a simple search
    Given I am on the homepage "https://www.saucedemo.com/?ref=hackernoon.com"
    When I enter the username "standard_user"
    And I enter the known password "secret_sauce"
    And I click on login button
    Then I am logged on the shop
