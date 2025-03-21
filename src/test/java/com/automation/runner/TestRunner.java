package com.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * This class serves as the test runner for executing Cucumber tests using JUnit.
 *
 * Key configurations:
 * - Uses the Cucumber JUnit runner (@RunWith(Cucumber.class)).
 * - Specifies the path to feature files in "src/test/resources/features".
 * - Indicates the package containing the step definitions ("com.automation.stepdefinitions").
 * - Configures plugins for report generation:
 *     - "pretty" for readable console output.
 *     - "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" to generate Allure report files.
 *     - "json:target/cucumber.json" to generate a JSON report.
 * - Sets monochrome to true for cleaner console output.
 *
 * Once tests are executed, the Allure plugin generates results in the default directory (e.g., "target/allure-results"),
 * which can later be served and viewed using the Allure CLI.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to feature files.
        glue = {"com.automation.stepdefinitions"}, // Package that contains step definitions.
        plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "json:target/cucumber.json" },
        monochrome = true
)
public class TestRunner { }
