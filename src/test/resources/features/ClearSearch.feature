Feature: Verify clear search history works

  Scenario: Verify clear search history works
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product1.name"
    Then verify user is on "product1.name" product page
    When user clicks on "Home"
    Then verify user is on home Page
    When user search for product "product2.name"
    Then verify user is on "product2.name" product page
    When user clicks on "Home"
    When user clicks on "Search"
    Then verify clear search is present
    When user clicks on clear search
    Then verify search history has been cleared


