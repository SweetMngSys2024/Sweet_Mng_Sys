Feature: User Management

  # Create an account
  Scenario: Create an account
    Given the admin is on the account management page
    When the admin clicks on "Create an account"
    Then the admin should be on the "Create an account" page

  # Delete an account
  Scenario: Delete an account
    Given the admin is on the account management page
    When the admin clicks on "Delete an account"
    Then the admin should be on the "Delete an account" page

Scenario Outline: View all accounts
    Given the admin is on the account management page
    When the admin clicks on "View Account"
    Then the account with username "<username>" and type "<account_type>" should be displayed

    Examples:
      | username | account_type |
      | bayan    | User         |
      | ahmad    | User         |
      | aya      | Admin        |
      | amer     | Admin        |
      | shams    | Owner        |
      | raghad   | Owner        |
      | rama     | Suppliers    |
      | amal     | Suppliers    |

Scenario Outline: View store details
    Given the admin is on the account management page
    When the admin clicks on "View store names"
    Then the store with name "<store_name>", city "<city>", and owner "<store_owner>" should be displayed
    
     Examples:
      | store_name | city   | store_owner |
      | Store A    | City X | shams       |
      | Store B    | City Y | raghad      |
     

       

Scenario Outline: View raw materials
    Given the admin is on the account management page
    When the admin clicks on "View raw materials"
    Then the raw material with name "<material_name>", and supplier "<supplier>" should be displayed

    Examples:
     | material_name | supplier |
     | Material A    | rama     |
     | Material B    | amal     |

    
    


























   #Edit account
  #Scenario: Edit account details
    #Given the admin is on the account management page
    #And the admin has selected the account using username "ali_123"
    #When the admin clicks on the "Edit"
    #Then the admin should be on the "Edit an account" page
#
  #Scenario: Trying to edit a non-existent account
    #Given the admin is on the account management page
    #And the admin tries to edit an account that does not exist
    #When the admin clicks on the "Edit" button
    #Then the system should show the message "The specified account does not exist. Please verify the username and try again."
#
  #Scenario: The admin leaves the username field blank
    #Given the admin enter "" in the user name field
     #When the admin clicks on the "Edit" button
    #Then an error message should appear saying "Please enter a username!"


  # Delete an account

  
  #Scenario: Delete an account by username
    #Given the admin is on the account management page
    #And the admin has selected the account using username "ahmed_123"
    #When the admin clicks on the "Delete"
    #Then the account should be successfully deleted from the system
    #And the system should show the message "The account has been successfully deleted from the system."
#
  #Scenario: Trying to delete a non-existent account
    #Given the admin is on the account management page
    #And the admin tries to delete an account that does not exist
    #When the admin clicks on the "Delete" button
    #Then the system should show the message "The specified account does not exist. Please verify the username and try again."
#
  #Scenario: The admin leaves the username field blank
    #Given Given the admin enter "" in the user name field
    #When the admin clicks on the "Delete" button
    #Then an error message should appear saying "Please enter a username!"
    #
    #Scenario: Completely removing an account from the system
  #Given an account with the username "ahmed_123" has been deleted
  #When I try to search for the deleted account in the system
  #Then I should not be able to find the deleted account


