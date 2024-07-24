  
  Feature: Edit user account 
  
  
    Background: 
     Given the admin is on the Edit an account page
     
  Scenario: View user profile information
  
    When the Admin choose view detials of the profile
    Then the information will displayed


   Scenario: Edit user profile information with valid inputs
     When the admin enters "Supplier" in the account type field
      And user enter "shams" in the first name field
    And  user enter "aziz" in the last name field
    And the Admin enter "shams_aziz" in user name field
    And the Admin enter "123" in password field
    And the Admin enter "shams123@gmail.com" in email field
    Then the massage "The information updated successfully" will displayed on screen
    And the information will be update
    

  Scenario Outline: Edit user profile information
   When the admin enters '<account type>' in the account type field
    And the user enter '<userName>' in user name field
     And user enter '<first name>' in the first name field
    And  user enter '<last name>' in the last name field
    And the user enter '<password>' in password field
    And the user enter '<email>' in email field
    Then the error '<massage>' will displayed on screen

    Examples: 
      |account type| userName |first name  | last name  | password | email              | massage                                |
      |Supplier    | bayan    |shams       | shams      | 123      | bayan123@.com      | please write the email in vaild format |
      |ABC         | bayan    |shams       | shams      | 123      | bayan123@gmail.com | please write the   valid account type  |  
      |Store Owner |          |bayan       | futyan     | 123      | bayan123@gmail.com | please write the user name             | 
      |Supplier    | bayan    |hassan      | ali        |          | bayan123@gmail.com | please write the password              | 
      |Store Owner | bayan    |leen        | ahmad      | 123      |                    | please write the email                 | 
      |            | bayan    |leen        | ahmad      | 123      | bayan123@gmail.com | please write the account type          |
      |Store Owner | Amer     |            | ahmad      | 123      |bayan123@gmail.com  | please write the first name            |
      |Supplier    | Amer     | ahmad      |            | 123      |bayan123@gmail.com  | please write the last name             |
      |            |          |            |            |          |                    | please write all fields                |
