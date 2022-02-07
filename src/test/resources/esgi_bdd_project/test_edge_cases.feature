Feature: Costs for (x) books

  Scenario Outline: What is my total with edge cases ?
    Given my basket contains "<id>"
    When I compute the total price
    Then I should pay <answer>

    Examples:
      | id                                            | answer |
      | 0,0,1,1,2,2,3,4                               | 50.4   |
      | 0,0,0,0,0,1,1,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,4 | 140.4  |



