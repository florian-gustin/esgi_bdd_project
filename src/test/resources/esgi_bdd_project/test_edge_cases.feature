Feature: Estimate the cost of a basket with some edge cases

  Scenario Outline: Basket contains
    Given the list of books "<id>"
    When I compute the price
    Then I should pay <answer>

    Examples:
      | id                                            | answer |
      | 0,0,1,1,2,2,3,4                               | 51.2   |
      | 0,0,0,0,0,1,1,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,4 | 141.2  |



