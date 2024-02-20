Feature: Get project

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

  Scenario Outline: Test get project method functionality with specific key
    When The user sends GET request to the get project endpoint with specific "<key>"
    Then The status code should be 200
    And The response should be equal key value as "<key>"
    Examples:
      | key |
      | T1  |
      | TT  |
