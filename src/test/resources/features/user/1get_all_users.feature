@users @smoke @regression
Feature: Get all users

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

  Scenario: Test get all users method fuctionality without parameters
    When The user sends a GET request to get all users endpoint
    Then The status code should be 200
    And The response must contain array of users

  Scenario: Test get all users method functionality with startAt and max results parameters
    When The user sends a GET request to get all users endpoint with "startAt" as 5 "maxResults" as 5
    Then The status code should be 200
    And The response array of users size must be 5

  Scenario: Test get all users method functionality with invalid startAt and max results parameters
    When The user sends a GET request to get all users endpoint with "startAt" as "abc" and "maxResults" as "cdfh"
    Then The status code should be 400




