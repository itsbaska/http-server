Feature: POST to /form
  Scenario: POST returns 201 status
    Given the server is running
    When I "POST" "my=data" to "/form"
    Then the response status should be 201
    And the response body should be empty