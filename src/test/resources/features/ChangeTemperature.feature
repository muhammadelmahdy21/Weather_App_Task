Feature: Change temperature unit

  Scenario Outline: Verify user can change temperature
    Given the app is launched
    When I click Menu
    And I click Unit setting
    And I change temperature unit to <Temperature>
    And I click Done button
    Then the temperature should be displayed

    Examples:
    | Temperature |
    |     "C"     |
    |     "F"     |
