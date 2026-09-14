# Automated UI Testing for TDL School web page

## Project Description

This project is an automated UI testing suite for an TDL School using Selenium WebDriver, TestNG, and Extent Reports.

## Installation Instructions

### Prerequisites

Ensure you have the following installed on your system:
- **Java Development Kit (JDK)**: JDK is installed
- **Maven**: Maven is installed
- **Browser**: Ensure Chrome browser is available on your machine.

### Steps to Set Up the Project

1. **Install Project Dependencies**:
   Run the following Maven command to install all required dependencies:
    ```bash
    mvn clean install
    ```


## Running Tests

### Using Maven

To run all tests, execute the following command:
```bash
mvn test
```

To run SMOKE test group:
```bash
mvn test -Dgroups=SMOKE
```

To run navigation test class:
```bash
mvn test -Dtest=NavigationTest
```

To run navigateCourse method test:
```bash
mvn clean test -Dtest=NavigationTest#navigateCourse
```
# Test Reports for Automated UI Testing

## Viewing Reports

### Report Generation

After running the automated tests, Extent Reports are automatically generated. These reports provide comprehensive insights into the test execution.

### Locating the Report

The generated test reports are stored in the following directory:

```plaintext
reports/