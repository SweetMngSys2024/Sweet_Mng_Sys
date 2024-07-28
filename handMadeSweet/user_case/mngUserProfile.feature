
Feature: manage user account

  Scenario: View user profile information
    Given that the user role is "User"
    When  the user is logged in
    Then the user can see his information 
    

   Scenario: Edit user profile information with valid inputs
    Given  that the user role is "User"
    When the user is logged in
    And the user enter "shams_aziz" in user name field
    And the user enter "123" in password field
    And the user enter "shams123@gmail.com" in email field
    Then the massage "The information updated successfully" will displayed on screen
    And the information will be update
    

  Scenario Outline: Edit user profile information
    Given  that the user role is "User"
    When the user is logged in
    And the user enter '<userName>' in user name field
    And the user enter '<password>' in password field
    And the user enter '<email>' in email field
    Then the error '<massage>' will displayed on screen

    Examples: 
      | userName  | password | email  | massage |
      | bayan | 123 | bayan123@gmail.com | please try anothe user name | 
      |  | 123 | bayan123@gmail.com | please write the user name | 
      | bayan123 |  | bayan123@gmail.com | please write the password | 
      | bayan123 | 123 |  | please write the email | 
      |  |  |  | please write all fields |
      | bayan123 | 123 | bayan123@.com | please write the email in vaild format | 
    
    

  Scenario: delete the account
    Given that the user role is "User"
    When the user is logged in
    Then the user can delete his account
    
    