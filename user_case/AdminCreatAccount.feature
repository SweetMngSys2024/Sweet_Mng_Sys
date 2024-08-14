  
Feature: Create an account for owner and Suppliers

  Scenario: Admin enter valid informations 
  Given The user role is "Admin"
    When  the Admin is logged in
    And user enter "sara" in first name field
    And  user enter "eid" in last name field
    And  user enter "password1234" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "sara123@eid.com" in email field
    And  user enter "Suppliers" in role type  field
    And  user enter "Ramallah" in city field where the user lives 
    And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
   Then the user registration to the system will be successful! 
    
   Scenario: Admin left first name field empty
 Given The user role is "Admin" 
    When  the Admin is logged in
    And user enter "" in first name field
   And  user enter "eid" in last name field
    And  user enter "password1234" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "sara123@eid.com" in email field
    And  user enter "Suppliers" in role type  field
    And  user enter "Ramallah" in city field where the user lives
    And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
    Then  an error message should appear "please enter your first name"
 
   
   Scenario: Admin left last name field blank
  Given The user role is "Admin"
    When  the Admin is logged in
    And user enter "sara" in first name field
    And  user enter "" in last name field
    And  user enter "password1234" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "sara123@eid.com" in email field
    And  user enter "Suppliers" in role type  field
    And  user enter "Ramallah" in city field where the user lives
    And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
    Then  an error message should appear "please enter your last name"


   Scenario: Admin left user name field blank
    Given The user role is "Admin"
    When  the Admin is logged in
     And user enter "sara" in first name field
    And  user enter "eid" in last name field
    And  user enter "password1234" in password field
    And  user enter "" in user name field
      And  user enter "sara123@eid.com" in email field
    And  user enter "Suppliers" in role type  field
    And  user enter "Ramallah" in city field where the user lives
    And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
    Then  an error message should appear "please enter your user name"
    
     
   Scenario: Admin left password field blank
    Given The user role is "Admin"
    When  the Admin is logged in
     And user enter "sara" in first name field
    And  user enter "eid" in last name field
    And  user enter "" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "sara123@eid.com" in email field
    And  user enter "Suppliers" in role type  field
    And  user enter "Ramallah" in city field where the user lives
    And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
    Then  an error message should appear "please enter your password"
  
  
   Scenario: Admin left email field blank
    Given The user role is "Admin"
    When  the Admin is logged in
       And user enter "sara" in first name field
    And  user enter "eid" in last name field
    And  user enter "password1234" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "" in email field
    And  user enter "Suppliers" in role type  field
    And  user enter "Ramallah" in city field where the user lives
     And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
    Then  an error message should appear "please enter your email"
   
     Scenario: Admin left role field blank
    Given The user role is "Admin"
    When  the Admin is logged in
   And user enter "sara" in first name field
    And  user enter "eid" in last name field
    And  user enter "password1234" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "sara123@eid.com" in email field
    And  user enter "" in role type  field
    And  user enter "Ramallah" in city field where the user lives
     And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
    Then  an error message should appear "please enter your role"
     
   
      Scenario: Admin left branch field blank
   Given The user role is "Admin"
    When  the Admin is logged in
    And user enter "sara" in first name field
    And  user enter "eid" in last name field
    And  user enter "password1234" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "sara123@eid.com" in email field
     And  user enter "Suppliers" in role type  field
     And  user enter "Ramallah" in city field where the user lives
     And  user enter "" in branch field
    And  user enter "Jenin" in city field
    Then  an error message should appear "please enter branch"
    
   
   
     Scenario: Admin left city field blank
    Given The user role is "Admin"
    When  the Admin is logged in
    And user enter "sara" in first name field
    And  user enter "eid" in last name field
    And  user enter "password1234" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "sara123@eid.com" in email field
     And  user enter "Suppliers" in role type  field
     And  user enter "Ramallah" in city field where the user lives
      And  user enter "Branch 3" in branch field
    And  user enter "" in city field
    Then  an error message should appear "please enter  city name"
     

    
   Scenario: Admin enters invalid email format 
    Given The user role is "Admin"
    When  the Admin is logged in
     And user enter "sara" in first name field
    And  user enter "eid" in last name field
    And  user enter "password1234" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "sara123@.com" in email field
     And  user enter "Suppliers" in role type  field
     And  user enter "Ramallah" in city field where the user lives
      And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
    Then  an error message should appear "Please enter your email in the valid format"
    
    
   Scenario: Admin enters invalid role
   Given The user role is "Admin"
    When  the Admin is logged in
    And user enter "sara" in first name field
    And user enter "eid" in last name field
    And user enter "password1234" in password field
    And user enter "sara_eid" in user name field
    And user enter "sara123@eid.com" in email field
    And  user enter "InvalidRole" in role type  field
    And  user enter "Ramallah" in city field where the user lives
     And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
    Then  an error message should appear "Invalid role type. Please enter either 'Owner' or 'Suppliers'."
    
 
Scenario: Verify branch in city
  Given The user role is "Admin"
  When  the Admin is logged in
  And user enters "Branch 3" as branch and "Jenin" as city
  Then the branch should be valid for the city

    
   Scenario: the username is used befor
   Given The user role is "Admin"
    When  the Admin is logged in
     And user enter "shams" in first name field
    And  user enter "aziz" in last name field
    And  user enter "password654" in password field
    And  user enter "shams" in user name field
    And  user enter "shams123@aziz.com" in email field
     And  user enter "Owner" in role type  field
     And  user enter "Ramallah" in city field where the user lives
      And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
    Then an error message should appear "Please try another username! "

    
  Scenario: Admin left the city where the owner lives empty 
  Given The user role is "Admin"
    When  the Admin is logged in
    And user enter "sara" in first name field
    And  user enter "eid" in last name field
    And  user enter "password1234" in password field
    And  user enter "sara_eid" in user name field
    And  user enter "sara123@eid.com" in email field
    And  user enter "Suppliers" in role type  field
    And  user enter "" in city field where the user lives 
    And  user enter "Branch 3" in branch field
    And  user enter "Jenin" in city field
   Then an error message should appear "Please don't let the city field empty! "