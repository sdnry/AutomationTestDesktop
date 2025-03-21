# Test Automation Project

This project is an automation test framework for web applications, using Selenium, Cucumber, JUnit, and Allure to generate interactive reports. It is designed to simplify writing, executing, and analyzing automated tests.

## Project Structure

- **com.automation.page**  
  Contains Page Objects that encapsulate web elements and actions on web pages.  
  *Example:* `ExampleScenarioPage` manages the login page.

- **com.automation.stepdefinitions**  
  Contains Cucumber step definitions that link feature file scenarios to Java methods.  
  *Examples:*  
  - `ExampleScenarioStep` defines the steps for the login scenario.  
  - `Hooks` configures the WebDriver setup and teardown before and after each scenario.

- **com.automation.runner**  
  Contains the `TestRunner` class, which configures and executes tests using JUnit and Cucumber.  
  It also generates reports using Allure and JSON.

- **com.automation.utils**  
  Provides utility classes for the project, including:  
  - `ConfigurationManager` for managing configuration properties.  
  - `DriverManager` for initializing the WebDriver based on the selected browser.

## Prerequisites

- **Java JDK:** Version 8 or higher.
- **Maven:** For dependency management and running tests.
- **Web Browser:** Chrome, Firefox, or Safari.
- **Allure CLI:** To generate and view reports.  
  *Installation examples:*  
  - **macOS:** `brew install allure`  
  - **Windows:** `scoop install allure`
- **WebDriverManager:** Automatically manages the downloading and configuration of Selenium drivers.

## Installation

1. **Clone the Repository:**

   ```bash
   git clone <REPOSITORY_URL>
   cd <REPOSITORY_NAME>
   
2. **Install Dependencies**

To install the project dependencies, run:

```bash
mvn clean install
```

## Running the Tests

To execute the tests, use the following Maven command:

```bash
mvn clean test
```

Test results will be generated in the /allure-results folder.

## Generating and Viewing the Allure Report

After running the tests, generate and view the Allure report by executing:

```bash
allure serve /allure-results
```

This command will start a local server and automatically open your browser with an interactive and detailed report.

## Configuration

Project configuration parameters are stored in the `cucumber.properties` file located in the classpath. You can define various properties, such as:

```properties
responsive.width=1024
responsive.height=768
```

You can also set the browser (CHROME, FIREFOX or SAFARI) and responsive mode (true or false) via system properties when running tests:

```bash
mvn clean test -DBrowser=CHROME -DResponsive=false
```

## Contributing

Contributions are welcome!

- **Fork** the repository.
- **Create** a branch for your feature (e.g., `feature/new-feature`).
- **Commit** your changes and push the branch.
- **Open** a Pull Request to submit your modifications.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact

For any questions or suggestions, please contact [sdnry@icloud.com].

