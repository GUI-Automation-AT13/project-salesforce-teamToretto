Feature: Create Individual

  @CreateIndividual @RegressionTest
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
     | salutation | lastname | firstname | birthdate  | dontProcess | dontMarket | exportIndividualsData | okToStorePiiDataElsewhere | blockGeolocationTracking | dontProfile | dontTrack | forgetThisIndividual | individualsAge |
     | Mr.        | Paul     | Jake      | 01/01/2000 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 13 or Older    |