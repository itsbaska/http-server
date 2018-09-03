Feature: POST GET PUT GET DELETE GET
  Scenario: /formData responds with 200
    Given the page content of "/formData" is empty
    When I request "GET" "/formData"
    Then the response status should be 200
    And the response body should be empty

  Scenario: POST to /formData
    When I "POST" "data=fatcat" to "/formData"
    Then the response status should be 200

  Scenario: GET formData after POST
    When I request "GET" "/formData"
    Then the response status should be 200
    And the response body should be "data=fatcat"

  Scenario: PUT formData data
    When I "PUT" "data=heathcliff" to "/formData"
    Then the response status should be 200

  Scenario: DELETE formData data
    When I request "DELETE" "/formData"
    Then the response status should be 200

  Scenario: GET formData after DELETE
    When I request "GET" "/formData"
    Then the response status should be 200
    And the response body should be empty