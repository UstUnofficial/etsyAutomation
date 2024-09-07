Feature: Add to watchlist functionality

  Scenario: Verify user can add to watchlist a product
    Given user opens the application
    Then verify user is on home Page
    When user clicks on "My eBay"
    Then verify "My eBay" title is displayed
    When user clicks on the sign in
    Then verify sign in page is displayed
    When usr clicks on the user email or username
    Then verify username input field is displayed
    When user does the sign in using the credentials "valid.userEmail" and "valid.password"
    Then verify username "valid.userName" is displayed
    When user clicks on "Home"
    Then verify user is on home Page
    When clicks on category
    And click on "Books & Magazines" from category
