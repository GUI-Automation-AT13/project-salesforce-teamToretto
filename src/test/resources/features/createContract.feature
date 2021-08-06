Feature: Create Contract

  @CreateContract
  Scenario: create a contract with only required fields
    Given I navigate to the "Contract" page
    When I create a new contract with required fields
      | Account Name           | TestAccount |
      | Contract Term (months) | 2           |
      | Contract Start Date    | 7/15/2021   |
    Then I verify Contract created with requirement fields

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


  @CreateContract
  Scenario: create a contract with Test Account as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Customer Signed Title   | tittle              |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name and Customer as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Customer Signed By      | TestContact         |
      | Customer Signed Title   | tittle              |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name and Customer as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Customer Signed By      | TestContact         |
      | Customer Signed Title   | tittle              |
      | Customer Signed Date    | 7/15/2021           |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name, Customer and price book as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Customer Signed By      | TestContact         |
      | Customer Signed Title   | tittle              |
      | Customer Signed Date    | 7/15/2021           |
      | Price Book              | Standard            |
      | Owner Expiration Notice | 30 Days             |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name, Customer and price book as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Customer Signed By      | TestContact         |
      | Customer Signed Title   | tittle              |
      | Customer Signed Date    | 7/15/2021           |
      | Price Book              | Standard            |
      | Owner Expiration Notice | 30 Days             |
      | Company Signed Date     | 7/19/2021           |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name, Customer and price book as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Customer Signed By      | TestContact         |
      | Customer Signed Title   | tittle              |
      | Customer Signed Date    | 7/15/2021           |
      | Price Book              | Standard            |
      | Owner Expiration Notice | 30 Days             |
      | Company Signed Date     | 7/19/2021           |
      | Special Terms           | Special Terms       |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name, Customer and price book as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Customer Signed By      | TestContact         |
      | Customer Signed Title   | tittle              |
      | Customer Signed Date    | 7/15/2021           |
      | Price Book              | Standard            |
      | Owner Expiration Notice | 30 Days             |
      | Company Signed Date     | 7/19/2021           |
      | Special Terms           | Special Terms       |
      | Description             | Description         |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name and price book as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Customer Signed Date    | 7/15/2021           |
      | Price Book              | Standard            |
      | Owner Expiration Notice | 30 Days             |
      | Company Signed Date     | 7/19/2021           |
      | Special Terms           | Special Terms       |
      | Description             | Description         |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name and price book as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Price Book              | Standard            |
      | Owner Expiration Notice | 30 Days             |
      | Company Signed Date     | 7/19/2021           |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name and price book as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Price Book              | Standard            |
      | Company Signed Date     | 7/19/2021           |
    Then I verify Contract created with all fields

  @CreateContract
  Scenario: create a contract with Account Name and price book as pre-postcondition
    Given I navigate to the "Contract" page
    When I create a new contract with all fields
      | Account Name            | TestAccount         |
      | Contract Term (months)  | 2                   |
      | Contract Start Date     | 8/15/2021           |
      | Price Book              | Standard            |
      | Owner Expiration Notice | 30 Days             |
    Then I verify Contract created with all fields
    