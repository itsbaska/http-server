Feature: GET /redirect
  Scenario: Server redirects to root path
    Given the server is running
    When I request "GET" "/redirect"
    Then the response status should be 302
    And the response header should include "Location" "http://127.0.0.1:3000/"