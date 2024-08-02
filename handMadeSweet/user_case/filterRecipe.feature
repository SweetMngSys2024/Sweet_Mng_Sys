
Feature:  filter the recipes
 

  Scenario: enter invalid option
    When user enter "5" 
    Then this "please choose valid option!" will displayed
   
  Scenario: enter blank option
    When user enter "" 
    Then this "please choose valid option!" will displayed

  Scenario Outline: enter valid option
    When user enter "<type>" 
    Then all recipes of this type will displayed

    Examples: 
      | type|
      | 1 |  
      | 2 | 
      |3|  
      |4|