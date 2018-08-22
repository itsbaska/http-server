Feature: GET /redirect
  Scenario: Server redirects to root path
    Given the server is running
    When I request "GET" "/redirect"
    Then the response status should be 302
    And the response header should include "Location" "/"

  @redirect
  Scenario: Redirects work with any port
    Given I start the server with the option "-p 5000"
    When I visit "/redirect" and follow the 302 Location
    Then the response status should be 200
