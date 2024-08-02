Feature: Gather and display statistics on registered users by City

Scenario: Count the number of registered users in each city
   Given The user role is "Admin" 
   When  the Admin is logged in 
   And selects the "User Registration in City" option
     And Admin enter "Nablus" in the city field
   Then The number of registered users in city "Nablus" should be displayed.


Scenario: Count the number of registered users in each city
   Given The user role is "Admin"
   When  the Admin is logged in 
   And selects the "User Registration in Branch" option
    And Admin enter "Branch 1" in the Branch field
   Then The number of registered users in branch "Branch 1" in city "Nablus" should be displayed.


Scenario: Count the number of registered users in each city
   Given The user role is "Admin"
   When  the Admin is logged in 
   And selects the "User Registration in all cities" option
   Then The number of registered users in all cities should be displayed..
   
    
   
   

   Scenario: Admin enter non-existent city
   Given The user role is "Admin"
   When  the Admin is logged in  
  And selects the "User Registration in City" option
   And Admin enter "non-existent city" in the city field
   Then an error message should appear "the City does not exist"  



   Scenario: Admin enter non-existent branch
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "User Registration in Branch" option
   And Admin enter "non-existent branch" in the city field
   Then an error message should appear "the branch does not exist"  


Scenario: Admin left city field empty
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "User Registration in City" option
   And Admin enter "" in the city field
   Then an error message should appear "please enter city name"  



   Scenario: Admin left branch field empty
   Given The user role is "Admin"
   When  the Admin is logged in  
    And selects the "User Registration in Branch" option
   And Admin enter "" in the city field
   Then an error message should appear "please enter Branch name" 



