Feature: Sorting items by price
@smoke
  Scenario: The user can sort the items by price
    Given The user is on the e-commerce website
    When The user searchs for "Sketchbook" from search box
    And The user sorts the results by price ascending
    Then The items should be sorted by price ascending
@smoke
    Scenario: The user can add the expensive item to the shopping chart
      Given The user is on the e-commerce website
      And The user searchs for "Sketchbook" from search box
      And The user sorts the results by price descending
      When The user adds the most expensive item to the shopping chart
      Then The most expensive item should be added to the shopping chart