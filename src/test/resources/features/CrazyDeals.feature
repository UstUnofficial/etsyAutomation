Feature: Crazy deals feature
  Scenario: Verify user can crazy deals can be viewed
    Given user opens the application
    When user goes to the food section
    Then verify crazy deal navigator is displayed
    When user opens each crazy deals
#    Then verify that crazy deal is opened