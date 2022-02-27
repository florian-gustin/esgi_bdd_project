Feature: Estimate the cost of a basket with simple discounts

  Scenario Outline: Basket contains
    Given the list of books "<id>"
    When I compute the price
    Then I should pay <answer>

    Examples:
      | id        | answer |
      | 0,1       | 15.2   |
      | 0,2,4     | 21.6   |
      | 0,1,2,4   | 25.6   |
      | 0,1,2,3,4 | 30     |


