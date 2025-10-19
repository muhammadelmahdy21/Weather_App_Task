Feature: Change time format

  Scenario Outline: Verify user can change time format to 12 hour
    Given the app is launched
    When I click Menu
    And I click Unit setting
    And I change time format to <Time>
    And I click Done button
    Then the time should be displayed

    Examples:
      |   Time    |
      | "12 Hour" |
      | "24 Hour" |