Feature: Add attachment to issue

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

  Scenario: Test add attachment to issue method functionality with valid issue id
    When The user sends POST request to add attachment endpoint to specified issue with png file
    Then The status code should be 200
    And The attachment id should not be empty or null
    And The response creation date must be the same with the date of creation date

  Scenario: Test add attachment to issue method functionality with invalid issue id
    When The user sends POST request to add attachment endpoint to specified issue with png file
    Then The status code should be 404
