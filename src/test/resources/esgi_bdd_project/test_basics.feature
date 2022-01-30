Feature: Costs for (x) books

  Scenario Outline: What is my total ?
    Given my basket contains "<id>"
    When I compute the total price
    Then I should pay <answer>

    Examples:
      | id              | answer  |
      |                 | 0       |
      | 1               | 8       |
      | 2               | 8       |
      | 3               | 8       |
      | 4               | 8       |
      | 1,1,1           | 24      |
