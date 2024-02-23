@endtoend @smoke @regression
Feature: End To End Test

  Scenario: Test Jira Api From End To End
    Given The user is in base URI
    And The authentication is completed to reach jira apis

    When The user sends a POST request to the create issue endpoint
    Then The status code should be 201
    And Validate that issue id is not empty or null
    And Validate key starts with "TT"

    When The user sends POST request to add comment endpoint with specific issue key
    Then The status code should be 201
    And The comment id should not be empty or null
    And The response text should be same with the given text in json file

    When The user sends DELETE request to the delete comment endpoint with specific comment id
    Then The status code should be 204
    And Verify that the specific comment is deleted

    When The user sends POST request to add attachment endpoint to specified issue with txt file
    Then The status code should be 200
    And The attachment id should not be empty or null
    And The response creation date must be the same with the date of creation date

    When The user sends DELETE request to delete attachment endpoint with attachment id
    Then The status code should be 204

    When The user sends GET request to the get issue endpoint with created id
    And Validate that the specified attachment deleted

