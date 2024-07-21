Feature: User login sweet

 
  Scenario: User Login with correct username and password
   Given user is on the login page
   And user logs in with username "bayan_123" and password "Bayan123" and role "user" logs in
    When user clicks on the login button
    Then the user should be logged into the system
    And a welcome message should appear

  Scenario: User Login with incorrect password
   Given user is on the login page
   And user logs in with username "bayan_123" and password "Wrong123" and role "user" logs in
    When user clicks on the login button
    Then the user should be logged out of the system
    And a failed login message should appear

  Scenario: User Login with incorrect username
   Given user is on the login page
   And user logs in with username "wrongbayan_123" and password "Bayan123" and role "user" logs in
    When  user clicks on the login button
    Then the user should be logged out of the system
    And a failed login message should appear

  Scenario: Admin Login with correct username and password
   Given user is on the login page
   And Admin logs in with username "leen_456" and password "Leen456" and role "Admin" logs in
    When Admin clicks on the login button
    Then Admin should be logged into the system
    And a welcome message should appear

  Scenario: Admin Login with incorrect password
   Given user is on the login page
   And Admin logs in with username "leen_456" and password "Wrong456" and role "Admin" logs in
    When  Admin clicks on the login button
    Then Admin should be logged out of the system
    And a failed login message should appear

  Scenario: Admin Login with incorrect username
   Given user is on the login page
   And Admin logs in with username "wrongleen_456" and password "Leen456" and role "Admin" logs in
    When  Admin clicks on the login button
    Then Admin should be logged out of the system 
    And a failed login message should appear

  Scenario: Owner Login with correct username and password
   Given user is on the login page
   And Owner logs in with username "shams_789" and password "Shams789" and role "Owner" logs in
    When Owner clicks on the login button
    Then Owner should be logged into the system
    And a welcome message should appear

  Scenario: Owner Login with incorrect password
   Given user is on the login page
   And Owner logs in with username "shams_789" and password "Wrong789" and role "Owner" logs in
    When Owner clicks on the login button
    Then Owner should be logged out of the system
    And a failed login message should appear

  Scenario: Owner Login with incorrect username
   Given user is on the login page
   And Owner logs in with username "wrongshams_789" and password "Shams789" and role "Owner" logs in
     When Owner clicks on the login button
    Then Owner should be logged out of the system
    And a failed login message should appear

  Scenario: Suppliers Login with correct username and password
   Given user is on the login page
   And Suppliers logs in with username "razan_555" and password "Razan555" and role "Suppliers" logs in
     When  Suppliers clicks on the login button
    Then Suppliers should be logged into the system
    And a welcome message should appear

  Scenario: Suppliers Login with incorrect password
   Given user is on the login page
   And Suppliers logs in with username "razan_555" and password "Wrong555" and role "Suppliers" logs in
      When Suppliers clicks on the login button
    Then Suppliers should be logged out of the system
    And a failed login message should appear

  Scenario: Suppliers Login with incorrect username
   Given user is on the login page
   And Suppliers logs in with username "wrongrazan_555" and password "Razan555" and role "Suppliers" logs in
     When  Suppliers clicks on the login button
    Then Suppliers should be logged out of the system
    And a failed login message should appear
    
    
    
    
   Scenario: User enter valid username format
    Given that the user enters "shams_123" in the username field
    When the user clicks on the login button
    Then  the user will be accepted
    
    
   Scenario: User enter invalid username 
    Given that the user enters "shams" in the username field
    When the user clicks on the login button
    Then  an error message should appear indicating that the username is invalid saying "Please try another username! "
    
    
      
   Scenario: The username is used befor
    Given that the user enters "shams_123" in the username field
    When the user clicks on the login button
    Then  an error message should appear indicating that the username is invalid saying "Please try another username! "
    
    
   Scenario: The user let the username field blank
    Given that the user enters "" in the username field
    When the user clicks on the login button
    Then  an error message should appear indicating that the username is invalid saying "Please enter username! "
    
    
     Scenario: User enter valid password with at least 1 uppercase and 1 lowercase letter
    Given that the user enters "Shams123" in the password field
    When the user clicks on the login button
    Then  the password will be accepted 
    
    
    
   Scenario: User enter valid password with at least 1 number
    Given that the user enters "Shams123" in the password field
    When the user clicks on the login button
    Then  the password will be accepted   
        
        
   Scenario: User enter invalid password 
    Given that the user enters "shams" in the password field
    When the user clicks on the login button
    Then  an error message should appear indicating that the password is invalid saying "Please try more secure password "
    

  Scenario: User let the password field blank 
    Given that the user enters "" in the password field
    When the user clicks on the login button
    Then  an error message should appear indicating that the password is invalid saying "Please enter your password "
    
    
    
    
    
