@issue
Feature: Delete issue

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis
    When The user sends a POST request to the create issue endpoint

  Scenario: Test delete issue method functionality
    When The user sends DELETE request to the delete issue endpoint
    Then The status code should be 204
    When The user sends GET request to the get issue endpoint with created id
    Then The status code should be 404