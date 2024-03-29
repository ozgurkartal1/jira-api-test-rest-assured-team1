@attachment @smoke @regression
Feature: Add attachment to issue

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis
    When The user sends a POST request to the create issue endpoint

  Scenario: Test add attachment to issue method functionality with valid issue id
    When The user sends POST request to add attachment endpoint to specified issue with txt file
    Then The status code should be 200
    And The attachment id should not be empty or null
    And The response creation date must be the same with the date of creation date

  Scenario: Test add attachment to issue method functionality with invalid issue key
    When The user sends POST request to add attachment endpoint with invalid "TTTTTTT-2456" key with txt file
    Then The status code should be 404
