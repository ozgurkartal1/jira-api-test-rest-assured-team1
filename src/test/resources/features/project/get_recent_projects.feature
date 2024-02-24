@project @smoke @regression
Feature: Get recent projects

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

  Scenario: Test get recent projects method functionality with valid endpoint
    When The user sends GET request to get recent projects endpoint
    Then The status code should be 200
    And The response features of projects should match with features in json file

  Scenario: Test get recent projects method functionality with invalid endpoint
    When The user sends GET request to get invalid recent projects endpoint as "/rest/api/3/project/recen"
    Then The status code should be 404


