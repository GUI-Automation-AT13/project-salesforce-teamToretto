Feature: Create Individual

  @CreateIndividual @SmokeTest
  Scenario: Create an Individual with required fields
    Given I go to the new Individual formular
    When I set the lastname "Paul"
    Then The Individual's name is displayed in the header

  @CreateIndividual @RegressionTest
  Scenario Outline: Create an Individual with given fields
    Given I go to the new Individual formular
    When I create an Individual with the following values
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
    Then The name displayed should contain <salutation> <firstname> and <lastname>
    And The created individual details should match the given values
    And The Individual List Page should contain a record with <firstname> and <lastname>
    Examples:
      | salutation | lastname | firstname | birthdate  | dontProcess | dontMarket | exportIndividualsData | okToStorePiiDataElsewhere | blockGeolocationTracking | dontProfile | dontTrack | forgetThisIndividual | individualsAge |
      | Mr.        | Paul     | Jake      | 01/01/2000 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 13 or Older    |