Feature: Manage account and update



  Scenario: View owner profile information 
   Given The User role is "Owner"  
   When  The Owner  is logged in  
   Then the Owner can see his information 
     

   Scenario: Edit Owner profile information with valid inputs
   Given The User role is "Owner" 
  When  The Owner  is logged in  
    And the Owner enter "shams_aziz" in user name field
    And the Owner enter "123" in password field
    And the Owner enter "shams123@gmail.com" in email field
    And the Owner enter "0598876754" in phoneNumber field
    Then The massage "The information updated successfully" will displayed on screen
    And The information will be update
    

  Scenario Outline: Edit Owner profile information
    Given The User role is "Owner" 
  When  The Owner  is logged in  
    And the Owner enter '<userName>' in user name field
    And the Owner enter '<password>' in password field
    And the Owner enter '<email>' in email field
    And the Owner enter '<phoneNumber>' in phoneNumber field 
   Then The error '<massage>' will displayed on screen

    Examples: 
      | userName  | password | email |phoneNumber| massage |
      | bayan     | 123 | bayan123@gmail.com |0598876754  |please try anothe user name | 
      |           | 123 | bayan123@gmail.com |0598876754  |please write the user name | 
      | bayan123  |     | bayan123@gmail.com |0598876754  |please write the password | 
      | bayan123  | 123 |                    |0598876754  | please write the email | 
      | bayan123  | 123 | bayan123@gmail.com |      | please write the phoneNumber|
      |           |     |                    |      | please write all fields |
      | bayan123  | 123 | bayan123@.com      |0598876754  | please write the email in vaild format | 
      
    
    

  Scenario: delete the account
   Given The User role is "Owner" 
  When  The Owner  is logged in  
    Then the Owner can delete his account
    
    