package com.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/*
 * This class is responsible for initializing the WebDriver based on the specified browser.
 * It uses WebDriverManager to setup the appropriate driver executable automatically.
 * Supported browsers include:
 * - "CHROME": Initializes a ChromeDriver.
 * - "FIREFOX": Initializes a FirefoxDriver.
 * - "SAFARI": Initializes a SafariDriver.
 *
 * If an unsupported browser is specified, an Exception is thrown.
 */
public class DriverManager {

    public static WebDriver initializeDriver(String browser) throws Exception {
        switch (browser) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "SAFARI":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            default:
                throw new Exception("UNKNOWN BROWSER");
        }
    }

}
