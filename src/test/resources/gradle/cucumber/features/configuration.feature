#@port5000
#Feature: Configuration
#  Scenario: Changing port
#    Given I am in a console shell
#    When I start the server with the option "-p 5000"
#    And I request "GET" "/" on port "5000"
#    Then the response status should be 200