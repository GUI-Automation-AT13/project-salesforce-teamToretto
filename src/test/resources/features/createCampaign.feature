Feature: Create Campaign

  @CreateCampaign
  Scenario: Create a campaign with only required fields
    Given I navigate to the "Campaign" page
    When I create a new campaign with required fields
      | Campaign Name           | New Campaign |
    Then I verify that the created Campaign contains the correct information
      And I verify that the date matches the creation date


  @CreateCampaign
  Scenario: Create a campaign with all required fields
    Given I navigate to the "Campaign" page
    When I create a new campaign with all fields
      | Campaign Name                 | New Campaign          |
      | Start Date                    | 7/15/2021             |
      | End Date                      | 8/18/2021             |
      | Expected Revenue in Campaign  | 200                   |
      | Budgeted Cost in Campaign     | 150                   |
      | Actual Cost in Campaign       | 100                   |
      | Num Sent in Campaign          | 100                   |
    Then I verify that the created Campaign contains the correct information
      And I verify that the date matches the creation date

  @CreateCampaign
  Scenario: Create a campaign with all required fields
    Given I navigate to the "Campaign" page
    When I create a new campaign with all fields
      | Campaign Name | New Campaign |
      | Start Date    | 8/15/2021    |
      | End Date      | 8/18/2021    |
    Then I verify Campaign created and matches with values of table