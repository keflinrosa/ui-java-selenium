Feature:

  Scenario: Create a new Disney account
    Given I access the Disney shop website
    And go to Create an Account
    When I filled up the new account form with <First Name>
  #<Last Name>, <Email>, <Password>, <Birth Date>, <Country> and <Postcode>