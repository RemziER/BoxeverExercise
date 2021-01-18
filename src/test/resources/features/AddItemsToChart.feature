Feature: Adding item to shopping chart
@smoke
  Scenario Outline: The user can add items to the shopping chart
    Given The user is on the e-commerce website
    When The user searchs "<item>"
    And The user adds the item to the shopping chart
    Then The "<item>" should be added to the shopping chart
    Examples:
    |item         |
    |turntable mat|