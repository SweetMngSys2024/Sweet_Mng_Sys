Feature: Monitor profits and generate financial reports.


 Scenario: Admin views total profits for a specific city      
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "City Profit Report" option
   And Admin enter "Nablus" in the city field
   Then the system should display the total profits for all branches in "Nablus"
   
   
  Scenario: Admin views total profits for a specific branch in a specific city  
  Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "Branch Profit Report" option
   And Admin enter "Branch 1" in the Branch field
   Then the system should display the total profits for branch "Branch 1" in "Nablus"
   
   
        Scenario: Admin views total profits for all cities
    Given  that the user role is "Admin"
    When the user is logged in 
    And selects the "Overall Profit Report" option
    Then the system should display the total profits for all cities
    

   Scenario: Admin enter non-existent city
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "City Profit Report" option
   And Admin enter "non-existent city" in the city field
   Then an error message should appear "the City does not exist"  



   Scenario: Admin enter non-existent branch
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "Branch Profit Report" option
   And Admin enter "non-existent branch" in the city field
   Then an error message should appear "the branch does not exist"  


Scenario: Admin left city field empty
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "City Profit Report" option
   And Admin enter "" in the city field
   Then an error message should appear "please enter city name"  



   Scenario: Admin left branch field empty
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "Branch Profit Report" option
   And Admin enter "" in the city field
   Then an error message should appear "please enter Branch name"  





