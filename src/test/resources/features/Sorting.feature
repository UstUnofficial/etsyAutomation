Feature: Sorting
  Scenario: Sorting with some filtering price Low to high
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product3.name"
    Then verify user is on "product3.name" product page
    When user apply filter option "Buy It Now"
    When user sorts with "lowToHigh"
    Then verify price is sorted in "lowToHigh" order

  Scenario: Sorting with some filtering price high to high
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product3.name"
    Then verify user is on "product3.name" product page
    When user apply filter option "Buy It Now"
    When user sorts with "highToLow"
    Then verify price is sorted in "highToLow" order

  Scenario: Sorting with some filtering price low to high then Best match then verify price is not sorted
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product3.name"
    Then verify user is on "product3.name" product page
    When user apply filter option "Buy It Now"
    When user sorts with "lowToHigh"
    When user sorts with "highToLow"
    When user sorts with "bestMatch"
    Then verify price is sorted not in "lowToHigh" order







