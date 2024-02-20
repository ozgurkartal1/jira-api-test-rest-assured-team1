Feature: Creating issue

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

    Scenario: Validate create issue method functionality
      When The user sends a POST request to the create issue endpoint
      Then The status code should be 201
      And Validate that issue id is not empty or null
      And Validate key starts with "TT"
