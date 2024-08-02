Feature: Manage sweet Recipes


    
    
Scenario: The Admin deletes a recipe successfully
 Given The user role is "Admin"
   When  the Admin is logged in  
   And the Admin  wenet Delete recipe with title  "pizza"
   Then the  recipe with title "pizza" should be successfully deleted 


Scenario: The Admin try deletes a non-existent recipe 
 Given The user role is "Admin"
   When  the Admin is logged in  
   And the Admin  wenet Delete recipe with title  "non-existent"
Then an error message should appear "the recipe does not exist" 


Scenario: The Admin left title field empty
 Given The user role is "Admin"
   When  the Admin is logged in   
   And the Admin  wenet Delete recipe with title  ""
Then an error message should appear "the title field empty  exist" 



  Scenario: View recipe information
    Given The user role is "Admin"
   When  the Admin is logged in  
    Then the Admin can see the all recipes 



Scenario: Edit recipe information with valid inputs
     Given The user role is "Admin"
   When  the Admin is logged in  
      And the user enter "pizza" in title field
    And the user enter "just a standerd Pizza" in description field
    And the user enter "Spicy salami, salt, tomato" in ingrediants field
     And the user enter "45 minutes" in time field
    Then the massage "The information updated successfully" will displayed on screen
    And The recipe  will be update


Scenario Outline: Edit recipe information
 Given The user role is "Admin"
   When  the Admin is logged in  
   And the user enter "<title>" in title field
    And the user enter "<ingrediants>" in ingrediants field
     And the user enter "<time>" in time field
   Then the error '<massage>' will displayed on screen
     
    Examples: 
      | title |ingrediants                | massage                 |
      |       |Spicy salami, salt, tomato | please enter a title!   |
      | Pizza |                           | please enter the ingrediants!|           

      




