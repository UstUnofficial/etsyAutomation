Feature: Book Searching Functionality
  Scenario: Verify user can search for Books
    Given user opens the application
    Then verify user is on home Page
    When clicks on category
    And click on "Books & Magazines" from category
    And click on "Books" from sub category
    Then verify user is on "Books" category page

