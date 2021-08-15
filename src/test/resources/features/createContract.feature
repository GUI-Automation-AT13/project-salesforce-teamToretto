Feature: Create Contract

  @CreateContract @DeleteContract
  Scenario: create a contract with only required fields
    Given I navigate to the Contract page
    When I create a new contract with required fields
      | Account Name           | TestAccount |
      | Contract Term (months) | 2           |
      | Contract Start Date    | 7/15/2021   |
    Then I verify that the created Contract contains the correct information
    And I verify that the date matches the creation date

  @Contract @CreateContract @DeleteContract @RegressionTest
  Scenario: Create a contract with all required fields
    Given I navigate to the Contract page
    When I create a new Contract with all fields
      | Account Name            | TestAccount   |
      | Contract Term (months)  | 2             |
      | Contract Start Date     | 7/15/2021     |
      | Customer Signed By      | TestContact   |
      | Customer Signed Title   | tittle        |
      | Customer Signed Date    | 7/15/2021     |
      | Price Book              | Standard      |
      | Owner Expiration Notice | 30            |
      | Company Signed Date     | 7/19/2021     |
      | Special Terms           | Special Terms |
      | Description             | Description   |
    Then I verify that the created Contract contains the correct information
    And I verify that the date matches the creation date

  @Contract @CreateContract @Tables
  Scenario: create a contract with only required fields
    Given I navigate to the Contract page
    When I create a new Contract with required fields
      | Account Name           | TestAccount |
      | Contract Term (months) | 2           |
      | Contract Start Date    | 7/15/2021   |
      | Status                 | Draft       |
    And I navigate to the Contract page
    Then I verify Contract created and matches with values of table