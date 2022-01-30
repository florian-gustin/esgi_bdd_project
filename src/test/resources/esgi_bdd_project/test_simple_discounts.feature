Feature: Costs for (x) books

  Scenario Outline: What is my total with simple discounts ?
    Given my basket contains "<id>"
    When I compute the total price
    Then I should pay <answer>

    Examples:
      | id              | answer  |
      | 0,1             | 15.2    |
      | 0,2,4           | 21.6    |
      | 0,1,2,4         | 25.6    |
      | 0,1,2,3,4       | 30    |


