Feature: Create Campaign

  @CreateWorkType
  Scenario: create a campaign with only required fields
    Given I login to Salesforce site as an admin user
    When I navigate to the "Campaign" page
    When I create a new campaign with required fields
      | Campaign Name           | New Campaign |
    Then I verify Campaign created with requirement fields


  @CreateWorkType
  Scenario: create a campaign with all required fields
    Given I login to Salesforce site as an admin user
    When I navigate to the "Campaign" page
    When I create a new campaign with all fields
      | Campaign Name                 | New Campaign          |
      | Start Date                    | 8/15/2021             |
      | End Date                      | 8/18/2021             |
      | Expected Revenue in Campaign  | 200                   |
      | Budgeted Cost in Campaign     | 150                   |
      | Actual Cost in Campaign       | 100                   |
      | Num Sent in Campaign          | 100                   |
    Then I verify Campaign created with all fields
