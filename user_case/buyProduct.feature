
Feature: Buy a product

  Scenario: Search for some product with valid input in search field
    When user enter "" in search field
    Then error msg will appear "please write something to search!"
    
  Scenario: Search for some product that does not exist in data base
    When user enter "pizza" in search field
    Then error msg will appear "can not found this product!" 

    
   Scenario: Search for some product theen enter zero qnt
    When user enter "Dark Chocolate" in search field
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "0" 
    And error msg will appear "please enter correct qnt!"
    
   Scenario: Search for some product that exist and want to buy it and there is enough qnt
    When user enter "Dark Chocolate" in search field
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "2" 
    And there is an enough quantity to buy it 
   
   Scenario: Search for some product that exist and want to buy it and there is no enough qnt
    When user enter "White Chocolate" in search field
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "5" 
    And there is no enough quantity to buy it 
    
  Scenario: Search for some product and do not want to buy it
    When user enter "Dark Chocolate" in search field
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "Cancel" 

  Scenario: user wants to buy product
    When user enter "Dark Chocolate" in buy field  
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "2" 
    And there is an enough quantity to buy it
    And he enters "Jenin" in city field and "Branch 3" in branch field

  Scenario: user wants to buy product
    When user enter "Dark Chocolate" in buy field  
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "2" 
    And there is an enough quantity to buy it
    And he enters "" in city field and "Branch 1" in branch field 
    
   Scenario: user wants to buy product
    When user enter "Dark Chocolate" in buy field  
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "2" 
    And there is an enough quantity to buy it
    And he enters "Jenin" in city field and "" in branch field
    Then an error message should appear "Please write the city!"
    
    
  Scenario: user wants to buy product
    When user enter "White Chocolate" in buy field 
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "5" 
    And there is no enough quantity to buy it

    
   Scenario: user do not wants to buy products
    When user enter "Dark Chocolate" in buy field 
    Then the information of this product will appear
     And the user can buy it if he enter the quantity that he wants or Cancel the process "Cancel" 
     
   Scenario: user enter invalid qnt
    When user enter "Dark Chocolate" in buy field 
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "" 
    And error msg will appear "please enter the qnt or Cancel!"
    
    
   Scenario: user enter zero in qnt
    When user enter "Dark Chocolate" in buy field 
    Then the information of this product will appear
    And the user can buy it if he enter the quantity that he wants or Cancel the process "0" 
    And error msg will appear "please enter correct qnt!"
    
   Scenario: user enter invalid input in buy field
    When user enter "" in buy field 
    Then error msg will appear "please choose correct option to buy!"
    
   Scenario: user enter wrong input in buy field
    When user enter "pizza" in buy field 
    Then error msg will appear "this product does not exist, try to choose another one!"
