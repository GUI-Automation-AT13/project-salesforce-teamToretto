Feature: Create an Campaign

  Scenario: Create a Campaign with required fields
    Given I navigate to "Campaign" page
    When I create a dateof Campaign with fields
    Then A successful message of creating is display
    And All header fields match
    And All detail fields match