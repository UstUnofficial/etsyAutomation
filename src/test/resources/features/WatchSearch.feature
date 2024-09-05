Feature: Watch Searching Functionality
  Scenario: Verify user can search for watches
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product1.name"
    Then verify user is on "product1.name" product page
    When select a brand "brand.name" from watches
    Then verify each product is from "brand.name"