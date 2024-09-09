Feature: Recent Search functionality

  Scenario: Verify user can see the recent searched product in recently viewed
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
    When user search for product "product4.name"
    Then verify user is on "product4.name" product page
    When user shop the product by size "M"
    And user shop the product by sleeve length "Short Sleeve"
    When user click on first product
    Then verify user is on first product
    And user store the product title as "product.title"
    When user go back to home page
    When user clicks on "My eBay"
    Then verify "My eBay" title is displayed
    And user click on Recently viewed
    Then verify the product is added to Recently viewed
    Then verify the recently searched product is visible

