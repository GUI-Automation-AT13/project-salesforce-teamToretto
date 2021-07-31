Feature: Create workType

  @CreateWorkType
  Scenario: create an workType with only required fields
    Given I login to Salesforce site as an admin user
    When I navigate to the "WorkType" page
    When I create a new workType with required fields
      | Work Type Name     | workType |
      | Estimated Duration | 2        |
    Then I verify WorkType created with requirement fields

  @CreateWorkType
  Scenario: create an workType
    Given I login to Salesforce site as an admin user
    When I navigate to the "WorkType" page
    When I create a new workType with all fields
      | Work Type Name                | workType            |
      | Estimated Duration            | 25                  |
      | Description                   | WorkTypeDescription |
      | Block Time Before Appointment | 3                   |
      | Block Time After Appointment  | 15                  |
      | Timeframe Start               | 4                   |
      | Timeframe End                 | 4                   |
    Then I verify WorkType created with all fields
