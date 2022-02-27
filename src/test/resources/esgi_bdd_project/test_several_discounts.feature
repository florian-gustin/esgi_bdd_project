Feature: Estimate the cost of a basket with several discounts

  Scenario Outline: Basket contains
    Given the list of books "<id>"
    When I compute the price
    Then I should pay <answer>

    Examples:
      | id              | answer  |
      | 0,0,1           | 23.2    |
      | 0,0,1,1         | 30.4    |
      | 0,0,1,2,2,3     | 40.8    |
      | 0,1,1,2,3,4     | 38      |


