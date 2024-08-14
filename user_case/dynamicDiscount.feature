
Feature: Dynamic Discount

Scenario: Successfully apply a discount on products with prices greater than or equal to the minimum price
    Given that user role is "Owner" and the user name "shams_imad"
    And he sets the minimum price to "200"
    And he sets the discount percentage to "0.1"
    When the system evaluates products in the inventory
    Then the discount should be applied to all products with prices greater than or equal to "200" 
    And a confirmation message should appear "Discount successfully applied to all eligible products"
    
    
  Scenario: No discount on products below the minimum price
    Given that user role is "Supplier" and the user name "rama_hasan"
    And he sets the minimum price to "200"
    And he sets the discount percentage to "0.15"
    When the system evaluates products in the inventory
    Then the discount should not be applied to any products with prices below "200"
    And a message should appear "No discounts applied to products below the minimum price"
    
    
    Scenario: Enter invalid minimum price (non-numeric)
    Given that user role is "Owner" and the user name "shams_imad"
    When he sets the minimum price to "two hundred"
    Then an error message should appear "Please enter a valid numeric value for the minimum price"
    
    
    Scenario: Enter invalid discount percentage (non-numeric or out of range)
    Given that user role is "Supplier" and the user name "rama_hasan"
    When he sets the discount percentage to "fifteen percent"
    Then an error message should appear "Please enter a valid percentage between 0% and 100%"
    
    Scenario: Enter a discount percentage greater than 100%
    Given that user role is "Owner" and the user name "shams_imad"
    When he sets the discount percentage to "1.5"
    Then an error message should appear "Discount percentage cannot exceed 100%"
    
    
    Scenario: Enter a negative discount percentage
    Given that user role is "Supplier" and the user name "rama_hasan"
    When he sets the discount percentage to "-0.1"
    Then an error message should appear "Discount percentage cannot be negative"
    
    
    