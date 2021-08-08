Feature: Create workType

  @CreateWorkType
  Scenario: create an workType with only required fields
    Given I navigate to the "WorkType" page
    When I create a new workType with required fields
      | Work Type Name     | workType |
      | Estimated Duration | 2.00     |
    Then I verify WorkType created with the given requirement fields
    And I verify that the date matches the creation date

  @CreateWorkType
  Scenario: create an workType
    Given I navigate to the "WorkType" page
    When I create a new workType with all fields
      | Work Type Name                | workType            |
      | Estimated Duration            | 25.00               |
      | Description                   | WorkTypeDescription |
      | Block Time Before Appointment | 3                   |
      | Block Time After Appointment  | 15                  |
      | Timeframe Start               | 4                   |
      | Timeframe End                 | 4                   |
    Then I verify WorkType created with all fields
    And I verify that the date matches the creation date

  @CreateWorkType
  Scenario: create an workType
    Given I navigate to the "WorkType" page
    When I create a new workType with all fields
      | Work Type Name     | workType            |
      | Estimated Duration | 25.00               |
      | Duration Type      | Hours               |
    Then I verify WorkType created in table
