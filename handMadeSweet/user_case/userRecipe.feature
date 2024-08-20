
Feature: post a recipe

  Scenario: The user enter valid information
    When the user enter "pizza" in title field
    And the user enter "shams_aziz" in user name field
    And the user enter "just a standerd pizza" in description field
    And the user enter "salami, salt, tomato" in ingrediants field
    And the user enter "10" in time field
    And the user enter "Gluten-Free" in type field
    Then the massage "The recipe added successfully" will displayed on screen
    And the recipe will be added successfully
    

    
   Scenario Outline: The user let the title blank
    When the user enter "<title>" in title field
    And the user enter "<userName>" in user name field in share recipe page
    And the user enter "<description>" in description field
    And the user enter "<ingrediants>" in ingrediants field
    And the user enter "<time>" in time field
     And the user enter "<type>" in type field
    Then the massage "<msg>" will displayed on screen

    Examples: 
      | title  | userName | description  | ingrediants |time |type| msg |
      |  | shams_aziz | just a standerd pizza | salami, salt, tomato | 10|Gluten-Free | please enter a title!|
      | pizza | shams_aziz | just a standerd pizza | | 10| Gluten-Free| please enter the ingrediants! |
      | pizza |  | just a standerd pizza | salami, salt, tomato | 10| Gluten-Free |please enter your user name! |
      | pizza | shams_aziz | just a standerd pizza | salami, salt, tomato | 10|  |please enter the type of recipe! |
      | pizza | shams_aziz | just a standerd pizza | salami, salt, tomato | 10| Keto |please enter available type for the recipe! |
      
      
   Scenario: The user enter invalid user name
    When the user enter "pizza" in title field
    And the user enter "shams_123" in user name field
    And the user enter "just a standerd pizza" in description field
    And the user enter "salami, salt, tomato" in ingrediants field
    And the user enter "10" in time field
     And the user enter "Gluten-Free" in type field
    Then the massage "please enter valid user name" will displayed on screen