Feature: Method Not Allowed
  Scenario: GET /file1
    Given the server is running
    When I request "GET" "/"
    Then the response status should be 200

  Scenario: PUT /file1
    Given the server is running
    When I request "PUT" "/"
    Then the response status should be 405

  Scenario: Invalid Request
    Given the server is running
    When I request "SOMETHING" "/"
    Then the response status should be 405

  Scenario: GET /text-file.txt
    Given the server is running
    When I request "GET" "/text-file.txt"
    Then the response status should be 200

  Scenario: POST /text-file.txt
    Given the server is running
    When I request "POST" "/text-file.txt"
    Then the response status should be 405