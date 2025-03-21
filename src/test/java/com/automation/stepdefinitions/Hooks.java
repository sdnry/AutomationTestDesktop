package com.automation.stepdefinitions;

import com.automation.utils.ConfigurationManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.automation.utils.DriverManager.initializeDriver;

/**
 * This Hooks class manages the setup and teardown of the WebDriver for each Cucumber scenario.
 *
 * Before each scenario:
 *
 *   - It reads the desired browser type from the system property "Browser" (defaulting to "CHROME").
 *   - It checks whether the tests should run in responsive mode via the system property "Responsive" (default is false).
 *   - Initializes the WebDriver using the DriverManager.
 *   - If not in responsive mode, the browser window is maximized.
 *   - If in responsive mode, it retrieves the window dimensions (width and height) from the configuration file using ConfigurationManager,
 *       and sets the window size accordingly. An exception is thrown if the dimensions are not correctly formatted.
 *   - Sets an implicit wait of 10 seconds for the WebDriver.
 *
 * After each scenario:
 *   The WebDriver instance is quit to ensure proper cleanup.
 */
public class Hooks {

    private final String browser = System.getProperty("Browser", "CHROME");
    private final boolean isResponsiveMode = Boolean.parseBoolean(System.getProperty("Responsive", "false"));
    public static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = initializeDriver(browser);
        if (!isResponsiveMode) {
            driver.manage().window().maximize();
        } else {
            ConfigurationManager configurationManager = new ConfigurationManager();
            try {
                int width = Integer.parseInt(configurationManager.getProperty("responsive.width"));
                int height = Integer.parseInt(configurationManager.getProperty("responsive.height"));
                driver.manage().window().setSize(new Dimension(width, height));
            } catch (Exception e) {
                throw new Exception("Bad format for width or height in configuration file");
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
