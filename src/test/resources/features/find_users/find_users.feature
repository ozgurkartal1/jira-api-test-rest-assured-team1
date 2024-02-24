@finduser @smoke @regression
Feature: Find users

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

  Scenario Outline:Test find users method functionality with specific query
    When The user sends GET request to find users endpoint with specific "<query>"
    Then The status code should be 200
    And The displayed name and email must contains "<query>"
    Examples:
      | query  |
      | Kartal |
      | Emir   |
