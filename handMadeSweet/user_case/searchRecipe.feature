
Feature: Search for a recipe

 
   Scenario: search for specific recipe
    When user enter "Chocolate Cake" in the search filed
    Then the information of these recipe will displayed
 

  Scenario Outline: search with invalid input
    When user enter "<input>" in the search filed
    Then this "<msg>" will be displayed

    Examples: 
      | input  | msg | 
      |  |     please do not let the search field blank | 
      | 123 |   sorry, we can not find what do you want   | 