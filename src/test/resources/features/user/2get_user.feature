@users @smoke @regression
Feature: Get a user

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

  Scenario: Test get a user method functionality with valid account id
    When The user sends GET request to get user endpoint with valid account id
    Then The status code should be 200
    And The user which has this account id should match with response user

  Scenario: Test get a user method functionality with invalid account id
    When The user sends GET request to get user endpoint with invalid account id as "CelloEmirÖzgürAdaMusaMerveGürol"
    Then The status code should be 404