Feature: monitore sales and profits


Scenario: total sales and profits in branch
   Given The User role is "Owner" 
  When  The Owner  is logged in   
  And   The "shams_imad" searches for the total sales and profits in the branch it manages
  Then  the system should display the total sales and profits in this branch
   
   
   
  Scenario: total sales and profits in the branch for a specific product
   Given The User role is "Owner" 
  When  The Owner  is logged in  
  And   The "shams_imad" searches for the total sales and profits in the branch it manages for a  product "White Chocolate"
  Then  the system should display the total sales and profits in this branch for a specific product "White Chocolate"
   
    
    Scenario: Best-selling products 
   Given The User role is "Owner" 
  When  The Owner  is logged in    
   And  The "shams_imad" searches for the best-selling products 
   Then the system should should be displayed as the best-selling product  in this branch

   