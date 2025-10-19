Feature: Check rain and humidity values
  Scenario: Verify user can see rain and humidity values of each hour for the next 6 hours
    Given the app is launched
    Then the rain and humidity values are displayed for the next 6 hours
