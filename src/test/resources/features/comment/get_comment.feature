@comment
Feature: Get comment

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

    When The user sends POST request to add comment endpoint with specific issue key
    Then The status code should be 201
    And The comment id should not be empty or null

  Scenario: Validate get comment method functionality
    When The user sends a GET request to get comment with specific comment id
    Then The status code should be 200
    And The response information should match with created comment information

  Scenario: Validate get comment method functionality with invalid Id
    When The user sends a GET request to get comment with invalid comment id as "gemacom"
    Then The status code should be 404
    And The error message "Can not find a comment for the id: gemacom."

  Scenario: Validate get comment method functionality with invalid endpoint
    When The user sends a GET request to  invalid get comment endpoint with specific comment id
    Then The status code should be 404
    And The error message should be "null for uri: https://inaracademy.atlassian.net/rest/api/3/issue"