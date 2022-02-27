Feature: Estimate the cost of a basket

  Scenario Outline: Basket contains
    Given the list of books "<id>"
    When I compute the price
    Then I should pay <answer>

    Examples:
      | id              | answer  |
      |                 | 0       |
      | 1               | 8       |
      | 2               | 8       |
      | 3               | 8       |
      | 4               | 8       |
      | 1,1,1           | 24      |
