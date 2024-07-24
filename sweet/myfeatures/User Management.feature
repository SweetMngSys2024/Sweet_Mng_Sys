Feature: User Management

  # Create an account
  Scenario: Create an account
    Given the admin is on the account management page
    When the admin clicks on the "Create an account"
    Then the admin should be on the "Create an account" page

  # Edit account
  Scenario: Edit account details
    Given the admin is on the account management page
    And the admin has selected the account using username "ali_123"
    When the admin clicks on the "Edit"
    Then the admin should be on the "Edit an account" page

  Scenario: Trying to edit a non-existent account
    Given the admin is on the account management page
    And the admin tries to edit an account that does not exist
    When the admin clicks on the "Edit" button
    Then the system should show the message "The specified account does not exist. Please verify the username and try again."

  Scenario: The admin leaves the username field blank
    Given the admin enter "" in the user name field
    When the admin clicks on the "Edit" button
    Then an error message should appear saying "Please enter a username!"

  # Delete an account
  Scenario: Delete an account by username
    Given the admin is on the account management page
    And the admin has selected the account using username "ahmed_123"
    When the admin clicks on the "Delete"
    Then the account should be successfully deleted from the system
    And the system should show the message "The account has been successfully deleted from the system."

  Scenario: Trying to delete a non-existent account
    Given the admin is on the account management page
    And the admin tries to delete an account that does not exist
    When the admin clicks on the "Delete" button
    Then the system should show the message "The specified account does not exist. Please verify the username and try again."

  Scenario: The admin leaves the username field blank
    Given Given the admin enter "" in the user name field
    When the admin clicks on the "Delete" button
    Then an error message should appear saying "Please enter a username!"


    # View Account
     Scenario: View an account
  Given the admin is on the account management page
  When the admin clicks on the "View Account"
  Then a list displaying all accounts with their respective account types should appear
  
    # View store names
     Scenario: View store names
     Given the admin is on the account management page
    When the admin clicks on the "View store names"
     Then a list displaying store names, their respective cities, and the names of the store owners should appear
     
     
    # View raw materials
    Scenario: View raw materials
   Given the admin is on the account management page
   When the admin clicks on the "View raw materials"
   Then a list displaying raw material names, their prices, and the names of the suppliers should appear