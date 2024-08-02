
Feature: Sign up information 
 

  Scenario: User enter valid informations
    When user enter "shams" in the first name field
    And  user enter "aziz" in the last name field
    And  user enter "shams123" in the password field
    And  user enter "shams_aziz" in the user name field
    And  user enter "shams123@aziz.com" in the email field
    Then the user registration to the system will be successful

    
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
    And  user enter "bayan" in the user name field
    And  user enter "shams123@aziz.com" in the email field
    Then an error message should appear "Please try another username! "



    