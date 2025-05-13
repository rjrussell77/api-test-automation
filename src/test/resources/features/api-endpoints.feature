Feature: API endpoint validation for localhost:5000

  Scenario Outline: Validate GET request to <endpoint>
    Given the API is available
    When I send a GET request to <endpoint>
    Then the response status code should be 200
    And the response should contain <expectedField>

    Examples:
      | endpoint         | expectedField    |
      | "/users"           | "name"             |
      | "/users"           | "email"            |

  Scenario Outline: Validate POST request to <endpoint>
    Given the API is available
    When I send a POST request to <endpoint> with payload <payload>
    Then the response status code should be 201
    And the response should contain <expectedField>

    Examples:
      | endpoint     | payload              | expectedField |
      | "/posts"       | "{\"title\":\"Test\"}"     | "title"         |
      | "/posts"       | "{\"title\":\"Hello\"}"    | "title"         |

  Scenario Outline: Validate PUT request to <endpoint>
    Given the API is available
    When I send a PUT request to <endpoint> with payload <payload>
    Then the response status code should be 200
    And the response should contain <expectedField>

    Examples:
      | endpoint         | payload                    | expectedField |
      | "/users/1"         | "{\"name\":\"Updated\"}"         | "name"          |
      | "/users/2"         | "{\"email\":\"new@example.com\"}"| "email"         |

  Scenario Outline: Validate DELETE request to <endpoint>
    Given the API is available
    When I send a DELETE request to <endpoint>
    Then the response status code should be 204

    Examples:
      | endpoint     |
      | "/posts/1"     |
      | "/posts/2"     |

  Scenario Outline: Validate unauthorized access to <endpoint>
    Given I am not authenticated
    When I send a GET request to <endpoint>
    Then the response status code should be 401

    Examples:
      | endpoint     |
      | "/users"       |
      | "/posts"       |

  Scenario Outline: Validate resource not found for <endpoint>
    Given the API is available
    When I send a GET request to <endpoint>
    Then the response status code should be 404

    Examples:
      | endpoint        |
      | "/users/9999"     |
      | "/posts/9999"     |
