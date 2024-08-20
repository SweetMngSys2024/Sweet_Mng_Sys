Feature: Gather and display statistics on registered users by City

Scenario: Count the number of registered users in all cities
   Given The user role is "Admin" 
   When  the Admin is logged in 
   Then he can see the statistics for all registered users
   
    
   Scenario: Admin enter non-existent city
   Given The user role is "Admin"
   When  the Admin is logged in  
   And Admin enter "non-existent city" in the city field search
   Then an error message should appear "the City does not exist"  



Scenario: Admin left city field empty
   Given The user role is "Admin"
   When  the Admin is logged in  
   And Admin enter "" in the city field search
   Then an error message should appear "please enter city name"  


Scenario: Admin fill city field with valid city name
   Given The user role is "Admin"
   When  the Admin is logged in  
   And Admin enter "Nablus" in the city field search
   Then the users in this city will appear  