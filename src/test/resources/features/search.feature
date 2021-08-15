Feature: Search bar

  @Search @RegressionTest
  Scenario Outline: Search input returns matching record names
    Given I search the text "<searchText>" on the header's search box
    Then The results should be displayed
    Then All the result record's names should contain the text "<searchText>"
    Examples:
      | searchText |
      | me         |
      | ind        |

  @Search @RegressionTest
  Scenario Outline: Search input with spaces returns matching record names
    Given I search the text "<searchText>" on the header's search box
    Then All the result record's names should contain the text "<searchText>"
    Examples:
      | searchText    |
      | standard user |

  @Search @RegressionTest
  Scenario Outline: Searching one character text displays message
    Given I search the text "<searchText>" on the header's search box
    Then A message notifying that the search term is too short should be displayed
    Examples:
      | searchText |
      | a          |
      | b          |
      | 1          |
      | #          |

  @Search
  Scenario: Searching a Contact's name after creating it should return a result
    Given I have an object Contact created with the following values
      | lastname | Castro |
    When I navigate to the Contact page
      And I search the text "Castro" on the header's search box
    Then The results should be displayed
    Then All the result record's names should contain the text "Castro"

  @Search
  Scenario: Searching a Campaign's name after creating it should return a result
    Given I have an object Campaign created with the following values
      | Name | new campaign |
    When I navigate to the Campaign page
    And I search the text "new campaign" on the header's search box
    Then The results should be displayed
    Then All the result record's names should contain the text "new campaign"