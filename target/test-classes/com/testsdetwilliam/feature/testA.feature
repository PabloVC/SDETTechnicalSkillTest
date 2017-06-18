Feature: Tech test stage William Hill possition
 
  Scenario: William Hill authentication and list games A-Z 
    Given William Hill website
    When Authentication with user "WHATA_FOG2" and password "F0gUaTtest"
    Then Count and list all the games in A-Z
    