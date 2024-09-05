Feature: sign in sign out feature

  Background:
    Given user opens the application
    Then verify user is on home Page
    When user clicks on "My eBay"
    Then verify "My eBay" title is displayed
    When user clicks on the sign in
    Then verify sign in page is displayed
    When usr clicks on the user email or username
    Then verify username input field is displayed

  Scenario: Verify user can login with valid credentials
    When user does the sign in using the credentials "valid.userEmail" and "valid.password"
    Then verify username "valid.userName" is displayed

  Scenario: Verify user can logout
    When user does the sign in using the credentials "valid.userEmail" and "valid.password"
    When user clicks on "My eBay"
    Then verify "My eBay" title is displayed
    When user clicks on settings
    Then verify user is on settings page
    When user clicks on the signOut link
    Then verify user is on home Page

  Scenario Outline: Verify user cannot login with invalid credentials
    When user does the sign in using the credentials "<Email>" and "<Password>"
    Then verify username input field is displayed

    Examples:
      | Email             | Password         |
      | valid.userEmail   | invalid.password |
      | invalid.userEmail | valid.password   |
      | invalid.userEmail | invalid.password |



