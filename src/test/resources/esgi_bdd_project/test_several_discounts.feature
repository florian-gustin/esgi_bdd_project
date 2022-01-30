Feature: Costs for (x) books

  Scenario Outline: What is my total with several discounts ?
    Given my basket contains "<id>"
    When I compute the total price
    Then I should pay <answer>

    Examples:
      | id              | answer  |
      | 0,0,1           | 23.2    |
      | 0,0,1,1         | 30.4    |
      | 0,0,1,2,2,3     | 40.8    |
      | 0,1,1,2,3,4     | 38      |


