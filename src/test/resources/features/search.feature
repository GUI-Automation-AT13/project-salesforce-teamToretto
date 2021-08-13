Feature: Search bar

  @Search @RegressionTest
  Scenario Outline: Search input returns matching record names
    Given I enter the text <searchText> on the header's search box
    When I press the Enter key
    Then All the result record's names should contain the text <searchText>
    Examples:
      | searchText   |
      | me           |
      | ind          |
      | standarduser |
