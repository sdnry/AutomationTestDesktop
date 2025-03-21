package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * This class manages the configuration properties for the automation framework.
 *
 * It loads properties from the "cucumber.properties" file located in the classpath.
 *
 * If the configuration file is not found, an error is logged using Log4j.
 *
 * Any IO exceptions encountered during the loading process are printed to the console.
 *
 * The getProperty method provides access to the loaded properties using a specified key.
 */
public class ConfigurationManager {

    private final Properties properties = new Properties();

    private final Logger logger = LogManager.getLogger(this.getClass());

    public ConfigurationManager() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("cucumber.properties")) {
            if (input == null) {
                logger.error("Sorry, unable to find config.properties");
                return;
            }

            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
