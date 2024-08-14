Feature: User Management


Scenario: Delete an account
     Given The user role is "Admin" 
    When  the Admin is logged in
    And the user deletes an account with username "bayan"
    Then the account with username "bayan" should be successfully deleted from the system
 

     Scenario: Trying to delete a non-existent account
     Given The user role is "Admin"
    When the Admin is logged in
    And the user deletes an account with username "bayan555"
    Then the system should show the message "The specified account does not exist"
    
   
     
      Scenario: View all accounts
    Given The user role is "Admin" 
    When the Admin is logged in
    Then View all user accounts and account type



Scenario: View raw materials
    Given The user role is "Admin"
    When the Admin is logged in
    Then View all material with name and supplier and price