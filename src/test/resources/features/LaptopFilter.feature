Feature: Laptop Filter Functionality
  Scenario: Verify user can apply filter options in Laptop
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product2.name"
    Then verify user is on "product2.name" product page
    When user apply filter options
    Then verify the product are displayed based on filtering



