Feature: Create workType

  @WorkType @CreateWorkType @DeleteWorkType @Classic
  Scenario: Create an workType with only required fields
    Given I navigate to the WorkType page
    When I create a new WorkType with required fields
      | Work Type Name     | workType |
      | Estimated Duration | 2.00     |
    Then I verify that the created WorkType contains the correct information
    And I verify that the date matches the creation date

  @WorkType @CreateWorkType @DeleteWorkType @RegressionTest
  Scenario: Create an workType
    Given I navigate to the WorkType page
    When I create a new WorkType with all fields
      | Work Type Name                | workType                 |
      | Estimated Duration            | 25.00                    |
      | Duration Type                 | Minutes                  |
      | Description                   | WorkTypeDescription      |
      | Operating Hours               | OperatingHours-test news |
      | Block Time Before Unit        | Minute(s)                |
      | Block Time Before Appointment | 3                        |
      | Block Time After Unit         | Minute(s)                |
      | Block Time After Appointment  | 15                       |
      | Timeframe Start               | 4                        |
      | Time Frame Start Unit         | Day(s)                   |
      | Timeframe End                 | 4                        |
      | Time Frame End Unit           | Day(s)                   |
    Then I verify that the created WorkType contains the correct information
    And I verify that the date matches the creation date

  @WorkType @CreateWorkType @Tables
  Scenario: Create an workType
    Given I navigate to the WorkType page
    When I create a new WorkType with all fields
      | Work Type Name     | workType |
      | Estimated Duration | 25.00    |
      | Duration Type      | Hours    |
     And I navigate to the WorkType page
    Then I verify WorkType created and matches with values of table
