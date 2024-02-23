@issue
Feature: Get issue with id or key

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

  Scenario: Test get issue method functionality
    When The user sends GET request to the get issue endpoint with created issue key
    Then The status code should be 200
    And The response id and key should match with created id and key
    And The self and avatarURLs shouldn't be empty

  Scenario: Test get issue method functionality
    When The user sends GET request to the get issue endpoint with created id
    Then The status code should be 200
    And The response id and key should match with created id and key
    And The self and avatarURLs shouldn't be empty


