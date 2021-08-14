Feature: Search bar

  @Search @RegressionTest
  Scenario Outline: Search input returns matching record names
    Given I enter the text <searchText> on the header's search box
    When I press the Enter key
    Then All the result record's names should contain the text <searchText>
    Examples:
      | searchText    |
      | me            |
      | ind           |
      | standard user |

  @Search @RegressionTest
  Scenario Outline: Search input returns matching record names
    Given I enter the text <searchText> on the header's search box
    When I press the Enter key
    Then All the result record's names should contain the text <searchText>
    Examples:
      | searchText |
      | me         |
      | ind        |

  @Search @RegressionTest
  Scenario Outline: Search input returns matching record names
    Given I enter the text <searchText> on the header's search box
    When I press the Enter key
    Then No results should be displayed for the <searchText> text
    Examples:
      | searchText                                                                                                     |
      | a                                                                                                              |
      | b                                                                                                              |
      | 1                                                                                                              |
      | asdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm |
      | #                                                                                                              |