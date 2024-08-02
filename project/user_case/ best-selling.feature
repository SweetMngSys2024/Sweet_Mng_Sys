Feature: Best-selling products

 Scenario: Best-selling products in each store
Given The user role is "Admin"
   When  the Admin is logged in  
   And  the Admin searches for the best-selling products in Branch "Branch 1"
   Then the system should should be displayed as the best-selling product in "Branch 1"




  Scenario: Best-selling products in a non-existent branch
    Given The user role is "Admin"
    When the Admin is logged in
    And the Admin searches for the best-selling products in a non-existent branch "Branch X"
    Then  an error message should appear "the branch does not exist"



  Scenario:  Admin left branch field empty
    Given The user role is "Admin"
    When the Admin is logged in
    And  the Admin searches for the best-selling products in Branch ""
    Then an error message should appear "please enter Branch name"  








    