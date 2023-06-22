# Automated API Testing using Cucumber

This project showcases automated tests for validating Place API's using Cucumber and REST Assured. It leverages the power of Cucumber for behavior-driven development (BDD) testing and RestAssured for robust API testing. Here's an overview of the project structure and key components:

# Prerequisites
1. Java 8 or higher
2. Maven

# Dependencies

**Cucumber:** The project relies on Cucumber for implementing behavior-driven development (BDD) tests. It uses the Cucumber Java and Cucumber JUnit dependencies (io.cucumber:cucumber-java and io.cucumber:cucumber-junit) with version 7.12.0. These dependencies enable you to write and execute Cucumber feature files with step definitions.

**Cucumber Reporting:** The project also utilizes the net.masterthought:cucumber-reporting dependency (version 5.7.5) to generate detailed reports based on Cucumber test results. The reports are generated during the verify phase of the Maven build.

**REST Assured:** For testing RESTful APIs, the project includes the io.rest-assured:rest-assured dependency (version 5.3.0). REST Assured is a popular Java library for making HTTP requests and validating responses in API testing.

**Jackson:** The project relies on the com.fasterxml.jackson.core:jackson-databind dependency (version 2.15.2) and com.fasterxml.jackson.dataformat:jackson-dataformat-yaml dependency (version 2.15.0-rc2) for working with JSON and YAML data formats. Jackson provides powerful serialization and deserialization capabilities for JSON and YAML data.

**JSON:** The project uses the org.json:json dependency (version 20160212) for working with JSON data during tests. This library allows parsing, creating, and manipulating JSON structures.

# Usage
**Step Definitions**

The step definition file (stepDefinition.java) contains the Java code that maps the Gherkin steps from the feature files to the corresponding test actions. Here's an overview of the available step definitions:

**• add_place_payload():** Sets up the request payload for adding a place.

**• user_calls_with_http_request(String resource, String httpMethod)**: Performs an HTTP request based on the provided resource and HTTP method.

**• the_api_call_got_success_with_status_code(Integer int1):** Verifies that the API call was successful by checking the status code.

**• in_response_body_is(String key, String value):** Verifies that a specific key in the response body has the expected value.

**• verify_place_id_created_using(String methodName):** Verifies the place_id created by calling a specific method.

**• deletePlaceAPI_Payload():** Sets up the request payload for deleting a place.

**Feature File**

The feature file (.feature file) contain the high-level descriptions of the test scenarios written in Gherkin format. Each scenario outlines the steps to be executed and the expected results. Here's an overview of the available feature files:

**ValidatePlaceAPIs.feature:** Contains scenarios for validating the functionality of the Place API's.

**@AddPlace:** Scenario for verifying if a place is successfully added using the AddPlace API.

**@DeletePlace:** This scenario aims to validate the functionality of the DeletePlace API by verifying whether it successfully deletes the added place or not

To run the tests, execute the feature files using a test runner, such as JUnit or TestNG, in your preferred IDE or through the command line.

# Reporting

Test reports are automatically generated after test execution, providing insights into test results and outcomes. Reports can be found in the default output directory specified in your testing framework configuration.

# Jenkinsfile

The Jenkinsfile contains a declarative Jenkins pipeline that automates the build and execution of the API-Cucumber project. The pipeline is divided into several stages, each responsible for a specific set of tasks.

**Checkout:** This stage checks out the source code from the Git repository hosted on GitHub. The pipeline uses the GitSCM plugin to clone the repository and fetch the latest code from the main branch.

**Initialize:** In this stage, the pipeline prints out the values of the PATH and M2_HOME environment variables. This step helps verify that the required environment variables are correctly set up.

**Download ChromeDriver:** This stage downloads the ChromeDriver binary for macOS by using curl to fetch the binary file from the ChromeDriver storage. The downloaded file is then unzipped, and executable permissions are set.

**Create data.yaml:** In this stage, the pipeline creates a data.yaml file located at src/main/java/POJO/data.yaml. This file is used to store configuration data for the tests. The pipeline sets the values for baseURI, queryKey, queryValue, and address by echoing them into the data.yaml file.

**Run Tests:** This stage executes the tests using Maven. The pipeline runs the command 'mvn test' to trigger the Maven build and test process. Before running the tests, the pipeline lists the files and directories present in the workspace using 'ls -al'.

Make sure you have Jenkins installed and properly configured to execute this pipeline. Additionally, ensure that you have the necessary dependencies and environment variables set up correctly for the project.

# TestRunner

The TestRunner class is a JUnit test runner class that configures and executes Cucumber tests for the API-Cucumber project. It utilizes the Cucumber library and JUnit framework to execute behavior-driven development (BDD) tests written in Gherkin syntax.

The class is annotated with the @RunWith(Cucumber.class) annotation, which indicates that the Cucumber test runner should be used to execute the tests. The @CucumberOptions annotation is used to specify the configuration options for the Cucumber execution.

# Getters and Setters & Yaml


Within the project, a data.yaml file containing secret code values is utilized. The getters and setters class enables the retrieval of these values from data.yaml. The dataReader class reads and maps these values to the ObjectMapper Java class. The base class calls the method of the dataReader class using its object, while the utils class extends the base class.

# Conclusion
This project demonstrates a powerful automated API testing framework utilizing Cucumber, REST Assured, and other essential dependencies. With its robust testing capabilities and comprehensive reporting, it enables efficient and reliable validation of Place API functionality. The pipeline automation and integration with Jenkins further streamline the testing process, enhancing the overall software development and quality assurance workflow.