Feature: Create workType

  @CreateWorkType @DeleteWorkType
  Scenario: Create an workType with only required fields
    Given I navigate to the "WorkType" page
    When I create a new workType with required fields
      | Work Type Name     | workType |
      | Estimated Duration | 2.00     |
    Then I verify that the created WorkType contains the correct information
    And I verify that the date matches the creation date

  @CreateWorkType @DeleteWorkType
  Scenario: Create an workType
    Given I navigate to the "WorkType" page
    When I create a new workType with all fields
      | Work Type Name                | workType            |
      | Estimated Duration            | 25.00               |
      | Description                   | WorkTypeDescription |
      | Block Time Before Appointment | 3                   |
      | Block Time After Appointment  | 15                  |
      | Timeframe Start               | 4                   |
      | Timeframe End                 | 4                   |
    Then I verify that the created WorkType contains the correct information
    And I verify that the date matches the creation date

  @CreateWorkType
  Scenario: Create an workType
    Given I navigate to the "WorkType" page
    When I create a new workType with all fields
      | Work Type Name     | workType |
      | Estimated Duration | 25.00    |
      | Duration Type      | Hours    |
     And I navigate to the "WorkType" page
    Then I verify WorkType created and matches with values of table
