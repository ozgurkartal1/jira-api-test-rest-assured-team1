@comment @smoke @regression
Feature: Add comment
  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis
    When The user sends a POST request to the create issue endpoint

    Scenario: Test add comment method functionality with valid endpoint
      When The user sends POST request to add comment endpoint with specific issue key
      Then The status code should be 201
      And The comment id should not be empty or null
      And The response text should be same with the given text in json file

      Scenario: Test add comment method functionality with invalid endpoint
        When The user sends POST request to wrong "/GEMACOM"
        Then The status code should be 404