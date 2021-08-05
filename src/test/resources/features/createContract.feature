Feature: Create Contract

  @CreateContract
  Scenario: create a contract with only required fields
    Given I navigate to the "Contract" page
    When I create a new contract with required fields
      | Account Name           | TestAccount |
      | Contract Term (months) | 2           |
      | Contract Start Date    | 7/15/2021   |
    Then I verify Contract created with the given requirement fields
      And I verify that the date matches the creation date

  @CreateContract
  Scenario: create a contract with all required fields
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 7/15/2021           |
      | Customer Signed By      | TestContact         |
      | Customer Signed Title   | tittle              |
      | Customer Signed Date    | 7/15/2021           |
      | Price Book              | Standard            |
      | Owner Expiration Notice | 30 Days             |
      | Company Signed Date     | 7/19/2021           |
      | Special Terms           | Special Terms       |
      | Description             | Description         |
    Then I verify Contract created with all fields
      And I verify that the date matches the creation date
