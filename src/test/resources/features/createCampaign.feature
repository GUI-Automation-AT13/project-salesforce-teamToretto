Feature: Create an Campaign

  Scenario: Create a Campaign with required fields
    Given I login to salesforce site as an developer user
    And I navigate to "Campaign" page
    When I create a new Campaign with fields
    Then A successful message of creating is display
    And All header fields match
    And All detail fields match
    And The title matches
    And The created date matches