
Feature: Delete a product

 
Scenario: Delete a product
     Given that the user role is "Owner" and his user name "shams_imad"
     And he can view all products in his branch
    When the user enters "Half Dark Chocolate" in product name field
    Then the product should be successfully deleted from the system
 

     Scenario: Trying to delete a non-existent product
    Given that the user role is "Owner" and his user name "shams_imad"
     And he can view all products in his branch
    When the user enters "Half" in product name field
    Then error msg will displayed "please choose valid product!"
    
   Scenario: Delete a product from a supplier
     Given that the user role is "Supplier" and his user name "rama_hasan"
     And he can view all products in his branch
    When the user enters "Half Dark Chocolate" in product name field
    Then the product should be successfully deleted from the system


  Scenario: Delete a product from a non verified person
     Given that the user role is "User" and his user name ""
    When the user enters "Half Dark Chocolate" in product name field
    Then error msg will displayed "You can't delete product!"
  