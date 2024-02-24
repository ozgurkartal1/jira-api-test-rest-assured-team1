@comment @smoke @regression
Feature: Delete comment
  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

    When The user sends POST request to add comment endpoint with specific issue key
    Then The status code should be 201
    And The comment id should not be empty or null

  Scenario: Validate delete comment method functionality
    When The user sends DELETE request to the delete comment endpoint with specific comment id
    Then The status code should be 204
    And Verify that the specific comment is deleted
