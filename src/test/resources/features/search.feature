Feature: Search bar

  @SearchBar @RegressionTest
  Scenario Outline: Search input returns objects and fields that matches the search
    Given The search bar on the header is visible
    When I enter a text to look for
      | search | <search> |
    And Click the Enter key
    Then The matched records name should contain the text entered
    Examples:
      | search |
      | Mr.    |