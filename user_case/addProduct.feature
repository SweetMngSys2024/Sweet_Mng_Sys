
Feature: Add a product from owner or supplier

  Scenario: add new product by owner
    Given that the user role is "Owner" and the user name "shams_imad"
    When he enter the product name "Almond Chocolate" in product name field
    And he enter the description "Chocolate with almond pieces" in description field
    And he enter the price "7.99" in price field
    And he enter the quantity "90" in quantity field
    And he enter the discount "0.12" in discount field
    Then the product will be added successfully to his branch
    
      Scenario: add new product by supplier
    Given that the user role is "Supplier" and the user name "rama_hasan"
    When he enter the product name "Almond Chocolate" in product name field
    And he enter the description "Chocolate with almond pieces" in description field
    And he enter the price "7.99" in price field
    And he enter the quantity "90" in quantity field
    And he enter the discount "0.12" in discount field
    Then the product will be added successfully to his branch
    
   Scenario: add existing product
    Given that the user role is "Owner" and the user name "shams_imad"
    When he enter the product name "Half Dark Chocolate" in product name field
    Then an error message should appear "This product has already exist!"
   
   
    Scenario Outline: User left some fields blank
   Given that the user role is "Supplier" and the user name "rama_hasan"
    When he enter the product name "<pName>" in product name field
    And he enter the description "<desc>" in description field
    And he enter the price "<price>" in price field
    And he enter the quantity "<qnt>" in quantity field
    And he enter the discount "<discount>" in discount field
    Then an error message should appear "<errorMassage>"
    
      Examples:
      | pName                | desc                                      | price | qnt  | discount | errorMassage                  |
      | Milk Chocolate       | Smooth milk chocolate                     |       | 120  | 0.05     | Please enter the price        |
      | Hazelnut Chocolate   | Chocolate with hazelnut pieces            | 7.49  |      | 0.1      | Please enter the quantity     |
      | Almond Chocolate     | Chocolate with almond pieces              | 7.99  | 90   |          | Please enter the discount     |
      | Raspberry Chocolate  | White chocolate with raspberry flavor     | 8.99  | 70j  | 0.12     | Please enter valid qnt        |
      |                      | Dark chocolate with orange essence        | 5.99  | 100  | 0.1      | Please enter the product name |
      | Coffee Chocolate     |                                           | 7.19  | 60   | 0.09     | Please enter the description  |
      | Raspberry Chocolate  | White chocolate with raspberry flavor     | 8.99  |  80  | m        | Please enter valid discount   |
      | Raspberry Chocolate  | White chocolate with raspberry flavor     | c     | 70   | 0.12     | Please enter valid price      |
      
    

