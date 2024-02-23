@attachment
Feature: Delete attachment

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis
    When The user sends a POST request to the create issue endpoint
    And The user sends POST request to add attachment endpoint to specified issue with txt file

  Scenario: Test delete attachment method functionality with attachment id
    When The user sends DELETE request to delete attachment endpoint with attachment id
    Then The status code should be 204
    When The user sends GET request to the get issue endpoint with created id
    And Validate that the specified attachment deleted
