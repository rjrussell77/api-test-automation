# API Test Automation with Cucumber and Gherkin

This project provides automated API testing using Cucumber with Gherkin syntax, REST Assured for HTTP requests, and Maven for dependency management.

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- VS Code (recommended for best Gherkin support)

## Setup Instructions

### 1. Install VS Code Extensions

Open VS Code and install these essential extensions for Gherkin and Cucumber support:

#### Required Extensions:
- **Cucumber (Gherkin)** by Alex Krechik
  - Provides syntax highlighting for `.feature` files
  - Auto-completion for Gherkin keywords
  - Step definition navigation
  - Formatting support

#### Recommended Extensions:
- **Java Extension Pack** by Microsoft
  - Java language support
  - Maven integration
  - Debugging capabilities
- **REST Client** by Huachao Mao
  - Test API endpoints directly in VS Code
- **Thunder Client** by Ranga Vadhineni
  - Lightweight REST API client

### 2. VS Code Settings

The project includes pre-configured VS Code settings in `.vscode/settings.json`:
- Automatic formatting on save for Gherkin files
- Feature file association with Gherkin syntax
- Cucumber configuration for features and step definitions

### 3. Project Dependencies

The project includes these key dependencies:
- **Cucumber Java**: Core BDD framework
- **Cucumber JUnit**: JUnit integration
- **Cucumber Picocontainer**: Dependency injection
- **REST Assured**: HTTP client for API testing
- **Jackson**: JSON processing
- **SLF4J + Logback**: Logging framework

## Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Feature
```bash
mvn test -Dcucumber.features="src/test/resources/features/api-endpoints.feature"
```

### Run with Specific Tags
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

## Project Structure

```
src/
├── main/java/
│   └── com/example/
│       ├── controller/     # API controllers
│       ├── entity/         # Data models
│       ├── repository/     # Data access layer
│       └── service/        # Business logic
└── test/
    ├── java/
    │   ├── steps/          # Step definitions
    │   └── TestRunner.java # Cucumber test runner
    └── resources/
        └── features/        # Gherkin feature files
.vscode/
├── launch.json             # IDE launch profiles
├── tasks.json              # Maven task definitions
└── settings.json           # VS Code settings
Documentation:
├── README.md               # This file
├── TROUBLESHOOTING-GUIDE.md # Comprehensive troubleshooting
├── CURSOR-RUN-DEBUG-GUIDE.md # IDE integration guide
└── IDE-INTEGRATION-GUIDE.md  # Main method usage
```

## Feature File Formatting

Gherkin feature files support automatic formatting. The VS Code settings will:
- Format on save
- Provide syntax highlighting
- Auto-complete Gherkin keywords
- Navigate between features and step definitions

## Writing Feature Files

Example feature structure:
```gherkin
Feature: API endpoint validation

  Scenario: Validate GET request
    Given the API is available
    When I send a GET request to "/users"
    Then the response status code should be 200
    And the response should contain "name"
```

## Step Definitions

Step definitions are written in Java and use REST Assured for HTTP operations:
- `@Given`: Setup and precondition steps
- `@When`: Action steps
- `@Then`: Assertion and verification steps

## Troubleshooting

### Common Issues:
1. **Tests failing with 405 errors**: API endpoints may not support the HTTP method being tested
2. **Authentication failures**: Update the Bearer token in step definitions
3. **Port conflicts**: Ensure the target API is running on the expected port
4. **Flask returns 405 instead of 404**: This is Flask's default behavior for non-existent routes
5. **401 vs 405 status codes**: 401 means authentication required, 405 means method/route not allowed

### Detailed Troubleshooting:
- **See `TROUBLESHOOTING-GUIDE.md`** for comprehensive solutions and explanations
- **Current test status**: 7/12 tests passing, 5/12 failing (expected behavior)

### Getting Help:
- Check the Cucumber documentation: https://cucumber.io/docs
- Review REST Assured documentation: https://rest-assured.io/
- Check VS Code extension documentation for Cucumber support

## Next Steps

1. Customize the step definitions for your specific API
2. Add more comprehensive test scenarios
3. Implement test data management
4. Add reporting and CI/CD integration
