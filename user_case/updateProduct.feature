
Feature: update product information

 
  Scenario: update a product 
    Given that the role of the user is "Owner" and his user name "shams_imad"
    And he can see all products in his branch befor updating
    When he enter the product name "Dark Chocolate" in the product name field
    And he enter the description "Chocolate with almond pieces" in the description field
    And he enter the price "7.99" in the price field
    And he enter the quantity "90" in the quantity field
    And he enter the discount "0.12" in the discount field
    And he enter the salesCount "120" in the salesCount field
    And he enter the supplier "rama" in the supplier field
    Then the product will be updated successfully to his branch

  Scenario: update a non-existing product 
    Given that the role of the user is "Owner" and his user name "shams_imad"
    And he can see all products in his branch befor updating
    When he enter the product name "Almond Chocolate" in the product name field
    Then an error message should appear "This product doesn't exist!"
    
    
  Scenario Outline: update product with blank fields
    Given that the role of the user is "Supplier" and his user name "rama"
    When he enter the product name "<pName>" in the product name field
    And he enter the description "<desc>" in the description field
    And he enter the price "<price>" in the price field
    And he enter the quantity "<qnt>" in the quantity field
    And he enter the discount "<discount>" in the discount field
    And he enter the salesCount "<salesCount>" in the salesCount field
    And he enter the supplier "<supplier>" in the supplier field
    Then an error message should appear "<errorMassage>"
    
      Examples:
      | pName                | desc                                      | price | qnt  | discount |salesCount  | supplier | errorMassage          |
      | Dark Chocolate       | Smooth milk chocolate                     |       | 120  | 0.05     |10   | rama     | Please enter the price        |
      |                      | Dark chocolate with orange essence        | 5.99  | 100  | 0.1      |20   | rama      | Please enter the product name |
      | Dark Chocolate       | Chocolate with hazelnut pieces            | 7.49  |      | 0.1      |100  | rama | Please enter the quantity     |
      | Dark Chocolate  | White chocolate with raspberry flavor     | 7.50     | 70   | 0.12     |  | rama | Please enter a sales count      |
      | Dark Chocolate  | White chocolate with raspberry flavor     | 7.50     | 70   | 0.12     | f | rama | Please enter a valid sales count      |
      | Dark Chocolate    | Chocolate with almond pieces              | 7.99  | 90   |          |20  | rama | Please enter the discount     |
      | Dark Chocolate  | White chocolate with raspberry flavor     | 8.99  | 70j  | 0.12     |50  | rama | Please enter valid qnt        |
      | Dark Chocolate  | White chocolate with raspberry flavor     | 7.50     | 70   | 0.12     |50  |   | Please enter the supplier name      |
      | Dark Chocolate  | White chocolate with raspberry flavor     | 7.50     | 70   | 0.12     |50  | nonExistingSupplier | Please enter valid supplier name      |
      | Dark Chocolate     |                                           | 7.19  | 60   | 0.09     |50  | rama | Please enter the description  |
      | Dark Chocolate  | White chocolate with raspberry flavor     | 8.99  |  80  | m        |50  | rama | Please enter valid discount   |
      | Dark Chocolate  | White chocolate with raspberry flavor     | c     | 70   | 0.12     |50  | rama | Please enter valid price      |
      
    
