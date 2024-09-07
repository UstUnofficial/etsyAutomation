Feature: Laptop Filter Functionality
  Scenario: Verify user can apply filter using condition
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product2.name"
    Then verify user is on "product2.name" product page
    When user apply filter option "Condition"
    And user apply subCategory "Good - Refurbished" from category
    And user search for result
    Then verify the product are displayed contains "Refurbished.Data" based on filtering

  Scenario: Verify user can apply filter using shipping option
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product2.name"
    Then verify user is on "product2.name" product page
    When user apply filter option "Shipping Options"
    And user apply subCategory "Free Shipping" from Shipping category
    And user search for result
    Then verify the product are displayed contains "FreeShipping.data" based on filtering


  Scenario: Verify user can apply filter using condition and shipping option
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product2.name"
    Then verify user is on "product2.name" product page
    When user apply filter option "Condition"
    And user apply subCategory "Good - Refurbished" from category
    When user apply filter option "Shipping Options"
    And user apply subCategory "Free International Shipping" from Shipping category
    And user search for result
    Then verify the product are displayed contains "Refurbished.Data"  and "FreeShipping.data" based on filtering





