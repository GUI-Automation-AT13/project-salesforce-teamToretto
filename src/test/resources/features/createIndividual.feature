Feature: Create Individual

  @CreateIndividual @RegressionTest @DeleteIndividual
  Scenario Outline: Create an Individual with given parameters
    Given I navigate to the "Individual" page
    When I create a new individual with required fields
      | salutation                | <salutation>                |
      | lastname                  | <lastname>                  |
      | firstname                 | <firstname>                 |
      | birthdate                 | <birthdate>                 |
      | dontProcess               | <dontProcess>               |
      | dontMarket                | <dontMarket>                |
      | exportIndividualsData     | <exportIndividualsData>     |
      | okToStorePiiDataElsewhere | <okToStorePiiDataElsewhere> |
      | blockGeolocationTracking  | <blockGeolocationTracking>  |
      | dontProfile               | <dontProfile>               |
      | dontTrack                 | <dontTrack>                 |
      | forgetThisIndividual      | <forgetThisIndividual>      |
      | individualsAge            | <individualsAge>            |
    Then The name displayed should contain "<salutation> <firstname> <lastname>"
    And The feature list Page should contain a record with "<firstname> <lastname>"
    Examples:
      | salutation | lastname                 | firstname   | birthdate  | dontProcess | dontMarket | exportIndividualsData | okToStorePiiDataElsewhere | blockGeolocationTracking | dontProfile | dontTrack | forgetThisIndividual | individualsAge |
      | Mr.        | Paul                     | Jake        | 01/01/1900   | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 13 or Older    |
      | Mr.        | Paul Jhon                | Jake        | 01/12/1910 | false       | true       | true                  | true                      | true                     | true        | true      | true                 | 13 or Older    |
      | Ms.        | abcd                     | Jake        | 01/01/1920 | true        | false      | true                  | true                      | true                     | true        | true      | true                 | 13 or Older    |
      | Ms.        | 1234                     | Jake        | 01/01/1930 | true        | true       | false                 | true                      | true                     | true        | true      | true                 | 13 or Older    |
      | Mrs.       | !#$%                     | Jake        | 01/01/1940 | true        | true       | true                  | false                     | true                     | true        | true      | true                 | 13 or Older    |
      | Mrs.       | 1234 !#$%                | Jake        | 01/01/1950 | true        | true       | true                  | true                      | false                    | true        | true      | true                 | 13 or Older    |
      | Dr.        | +_)(*                    | Jake        | 01/01/1960 | true        | true       | true                  | true                      | true                     | false       | true      | true                 | 13 or Older    |
      | Dr.        | a really very large name | Jake        | 01/01/1970 | true        | true       | true                  | true                      | true                     | true        | false     | false                | 16 or Older    |
      | Prof.      | Paul                     | Jake Daniel | 01/01/1980 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 16 or Older    |
      | Prof.      | Paul                     | abcd        | 01/01/1990 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 16 or Older    |
      | Mr.        | Paul                     | 1234        | 01/01/2000 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 16 or Older    |
      | Mr.        | Paul                     | !#$%        | 01/01/2010 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 16 or Older    |
      | Ms.        | Paul                     | 1234 !#$%   | 01/01/2020 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 16 or Older    |
      | Ms.        | Paul                     | +_)(*       | 01/01/2010 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 16 or Older    |


  @CreateIndividual @RegressionTest @DeleteIndividual
  Scenario Outline: Create an Individual with given parameters
    Given I navigate to the "Individual" page
    When I create a new individual with required fields
      | lastname | <lastname> |
      And I navigate to the "Individual" page
    Then I verify Individual created and matches with values of table
    Examples:
      | lastname |
      | Cascada  |