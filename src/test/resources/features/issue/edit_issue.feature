@issue @regression
Feature: Edit issue feature

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis
    When The user sends a POST request to the create issue endpoint

  Scenario:Test edit issue method functionality
    When The user sends PUT request to the edit issue endpoint with creating issue key
    Then The status code should be 204
    And Validate that issue has been updated successfully

  Scenario:Test edit issue method functionality
    When The user sends PUT request to the edit issue endpoint with creating id
    Then The status code should be 204
    And Validate that issue has been updated successfully