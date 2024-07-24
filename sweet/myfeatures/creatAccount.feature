Feature: create user account 

  Background: 
    Given the admin is on the Create an account page

  Scenario: Valid account type "Store Owner"
  
    When the admin enters "Store Owner" in the account type field
    Then the input should be accepted
    And the account should be created successfully
    And the user can add new products
    And the user can edit existing product details
    And the user can delete products
    And the user can manage inventory and prices

  Scenario: Valid account type "Supplier"
  
    When the admin enters "Supplier" in the account type field
    Then the input should be accepted
    And the account should be created successfully
    And the user can view the list of available products in the store
    And the user can view available quantities and prices
    And the user does not have permission to edit, add, or delete products
    
    
    Scenario: User left account type field empty
    When  the admin enters "" in the account type field
    Then  an error message should appear "please enter your account type "
    
      Scenario: Invalid account type "InvalidType"
    When the admin enters "InvalidType" in the account type field
    Then an error message should appear "Invalid account type"


  Scenario: User enter valid informations
    When user enter "shams" in the first name field
    And  user enter "aziz" in the last name field
    And  user enter "shams123" in the password field
    And  user enter "shams_aziz" in the user name field
    And  user enter "shams123@aziz.com" in the email field
    Then the account should be created successfully



     Scenario: User left account type field empty
    When   user enter "shams" in the first name field
    And  user enter "aziz" in the last name field
    And  user enter "shams123" in the password field
    And  user enter "shams_aziz" in the user name field
    And  user enter "shams123@aziz.com" in the email field
    Then  an error message should appear "please enter your first name"

    
    
   Scenario: User left first name field empty
    When user enter "" in the first name field
    And  user enter "aziz" in the last name field
    And  user enter "shams123" in the password field
    And  user enter "shams_aziz" in the user name field
    And  user enter "shams123@aziz.com" in the email field
    Then  an error message should appear "please enter your first name"

    
   Scenario: User left last name field blank
    When user enter "shams" in the first name field
    And  user enter "" in the last name field
    And  user enter "shams123" in the password field
    And  user enter "shams_aziz" in the user name field
    And  user enter "shams123@aziz.com" in the email field
    Then  an error message should appear "please enter your last name"

 
   Scenario: User left user name field blank
    When user enter "shams" in the first name field
    And  user enter "aziz" in the last name field
    And  user enter "shams123" in the password field
    And  user enter "" in the user name field
    And  user enter "shams123@aziz.com" in the email field
    Then  an error message should appear "please enter your user name"
    
      
   Scenario: User left password field blank
    When user enter "shams" in the first name field
    And  user enter "aziz" in the last name field
    And  user enter "" in the password field
    And  user enter "shams_aziz" in the user name field
    And  user enter "shams123@aziz.com" in the email field
    Then  an error message should appear "please enter your password"
  
    
   Scenario: User left email field blank
    When user enter "shams" in the first name field
    And  user enter "aziz" in the last name field
    And  user enter "shams123" in the password field
    And  user enter "shams_aziz" in the user name field
    And  user enter "" in the email field
    Then  an error message should appear "please enter your email"
     
    
   Scenario: User enters invalid email format 
    When user enter "shams" in the first name field
    And  user enter "aziz" in the last name field
    And  user enter "shams123" in the password field
    And  user enter "shams_aziz" in the user name field
    And  user enter "shams123@.com" in the email field
    Then an error message should appear "Please enter your email in the valid format"
    
   
   Scenario: The username is used befor
     When user enter "shams" in the first name field
    And  user enter "aziz" in the last name field
    And  user enter "shams123" in the password field
    And  user enter "existing_user_name" in the user name field
    And  user enter "shams123@aziz.com" in the email field
    Then an error message should appear "Please try another username! "