
Feature: User login sweet


  Scenario: User Login with correct username and password
   Given user is not in the sweet system
   And user logs in with username "bayan_123" and password "Bayan123" and role "user" logs in
    When user clicks on the login button
    Then the user should be logged into the system
    

  Scenario: User Login with incorrect password
   Given user is not in the sweet system
   And user logs in with username "bayan_123" and password "Wrong123" and role "user" logs in
    When user clicks on the login button
    Then a failed login message should appear
    

  Scenario: User Login with incorrect username
   Given user is not in the sweet system
   And user logs in with username "wrongbayan_123" and password "Bayan123" and role "user" logs in
    When  user clicks on the login button
    Then a failed login message should appear
   

  Scenario: Admin Login with correct username and password
   Given user is not in the sweet system
   And Admin logs in with username "leen_456" and password "Leen456" and role "Admin" logs in
    When Admin clicks on the login button
    Then Admin should be logged into the system
    

  Scenario: Admin Login with incorrect password
   Given user is not in the sweet system
   And Admin logs in with username "leen_456" and password "Wrong456" and role "Admin" logs in
    When  Admin clicks on the login button
    Then a failed login message should appear
   

  Scenario: Admin Login with incorrect username
   Given user is not in the sweet system
   And Admin logs in with username "wrongleen_456" and password "Leen456" and role "Admin" logs in
    When  Admin clicks on the login button
    Then a failed login message should appear
     

  Scenario: Owner Login with correct username and password
   Given user is not in the sweet system
   And Owner logs in with username "shams_789" and password "Shams789" and role "Owner" logs in
    When Owner clicks on the login button
    Then Owner should be logged into the system
    

  Scenario: Owner Login with incorrect password
   Given user is not in the sweet system
   And Owner logs in with username "shams_789" and password "Wrong789" and role "Owner" logs in
    When Owner clicks on the login button
    Then a failed login message should appear
     

  Scenario: Owner Login with incorrect username
   Given user is not in the sweet system
   And Owner logs in with username "wrongshams_789" and password "Shams789" and role "Owner" logs in
     When Owner clicks on the login button
    Then a failed login message should appear
    

  Scenario: Suppliers Login with correct username and password
   Given user is not in the sweet system
   And Suppliers logs in with username "razan_555" and password "Razan555" and role "Suppliers" logs in
     When  Suppliers clicks on the login button
    Then Suppliers should be logged into the system
    

  Scenario: Suppliers Login with incorrect password
   Given user is not in the sweet system
   And Suppliers logs in with username "razan_555" and password "Wrong555" and role "Suppliers" logs in
      When Suppliers clicks on the login button
    Then a failed login message should appear
     

  Scenario: Suppliers Login with incorrect username
   Given user is not in the sweet system
   And Suppliers logs in with username "wrongrazan_555" and password "Razan555" and role "Suppliers" logs in
     When  Suppliers clicks on the login button
    Then a failed login message should appear
     
    

    Scenario: User left password field blank
   When  user enter "" in the password field
    And  user enter "shams_aziz" in the user name field
    Then  an error message should appear "please enter your password"
    
    
     Scenario: User left user name field blank
    When user enter "" in the user name field
    And  user enter "shams123" in the password field
    Then  an error message should appear "please enter your user name"
  
    
    
