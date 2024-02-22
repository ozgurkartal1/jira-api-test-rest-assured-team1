Feature: Update comment

  Background:
    Given The user is in base URI
    And The authentication is completed to reach jira apis

    When The user sends POST request to add comment endpoint with specific issue key
    Then The status code should be 201
    And The comment id should not be empty or null

  Scenario: Validate update comment method functionality
    When The user sends PUT request to the update comment endpoint with specific comment id
    Then The status code should be 200

    When The user sends a GET request to get comment with specific comment id
    Then The status code should be 200
    And The user validates that text has been updated as expected


  Scenario: Validate update comment method functionality with invalid id
    When The user sends PUT request to the update comment endpoint with invalid comment id as "111111111"
    Then The status code should be 404
    And The error message should be displayed

