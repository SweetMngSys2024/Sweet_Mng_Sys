Feature: Monitor profits and generate financial reports.


 Scenario: Admin views total profits for a specific city       
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "City Profit Report" option
   And Admin enter "Nablus" in city field
   Then the system should display the total profits for all branches in "Nablus"
   And the system should display all orders for this city with their users
   
   
  Scenario: Admin views total profits for a specific branch in a specific city  
  Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "Branch Profit Report" option
   And Admin enter "Branch 1" in branch field
   Then the system should display the total profits for branch "Branch 1" in "Nablus"
    And the system should display all orders for this branch with their users
   
   
        Scenario: Admin views total profits for all cities
    Given  that the user role is "Admin"
    When the user is logged in 
    And selects the "Overall Profit Report" option
    Then the system should display the total profits for all cities
    And the system should display all orders with their users
    

   Scenario: Admin enter non-existent city
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "City Profit Report" option
   And Admin enter "non-existent city" in city field
   Then an error message should appear "the City does not exist"  



   Scenario: Admin enter non-existent branch
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "Branch Profit Report" option
   And Admin enter "non-existent branch" in branch field
   Then an error message should appear "the branch does not exist"  


Scenario: Admin left city field empty
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "City Profit Report" option
   And Admin enter "" in city field
   Then an error message should appear "please enter city name"  



   Scenario: Admin left branch field empty
   Given The user role is "Admin"
   When  the Admin is logged in  
   And selects the "Branch Profit Report" option
   And Admin enter "" in branch field
   Then an error message should appear "please enter Branch name"  