Feature: Create Campaign

  @CreateWorkType
  Scenario: create a campaign with only required fields
    Given I login to Salesforce site as an admin user
    When I navigate to the "Campaign" page
    When I create a new campaign with required fields
      | Campaign Name           | New Campaign |
    Then I verify Campaign created with requirement fields