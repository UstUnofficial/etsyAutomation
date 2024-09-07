Feature: Add to watchlist functionality

  Background:
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

#  This 1st Scenario work in progress yet to complete!!!!!!!!!!!!!!!!!!!!!!!!
  Scenario: Verify user can add to watchlist....
    And click on "Home & Garden" from category
    And click on "School Supplies" from sub category
    And click on "Pens & Pencils" from inner sub category
    Then verify user is on "Pens & Pencils" category page
    And user select color as "Blue"
    And user select gender as "Boys & Girls"
    And user click on first product
    And user click on "Add to watchlist" button
    And user go back to home page
    Then verify user is on home Page
    When user clicks on "My eBay"
    Then verify "My eBay" title is displayed
    And user click on watchlist
   Then verify the product is added to watch list


  Scenario: Verify user can remove product from watchlist
    And click on "Clothing, Shoes & Accessories" from category
    And click on "Baby" from sub category
    And click on "Baby Shoes" from inner sub category
    Then verify user is on "Baby Shoes" category page
    And user click on first product
    And user click on "Add to watchlist" button
    And user go back to home page
    When user clicks on "Home"
    Then verify user is on home Page
    When user clicks on "My eBay"
    Then verify "My eBay" title is displayed
    And user click on watchlist
    Then verify the product is added to watch list
    When user remove the product from watchlist
    Then verify the watchlist is empty


  Scenario: Verify user can add product to watchlist
    And click on "Clothing, Shoes & Accessories" from category
    And click on "Baby" from sub category
    And click on "Baby Shoes" from inner sub category
    Then verify user is on "Baby Shoes" category page
    And user click on first product
    And user click on "Add to watchlist" button
    And user go back to home page
    When user clicks on "Home"
    Then verify user is on home Page
    When user clicks on "My eBay"
    Then verify "My eBay" title is displayed
    And user click on watchlist
    Then verify the product is added to watch list







