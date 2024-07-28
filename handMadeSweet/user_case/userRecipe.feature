
Feature: post a recipe

  Scenario: The user enter valid information
    When the user enter "pizza" in title field
    And the user enter "shams_aziz" in user name field
    And the user enter "just a standerd pizza" in description field
    And the user enter "salami, salt, tomato" in ingrediants field
    And the user enter "10" in time field
    Then the massage "The recipe added successfully" will displayed on screen
    And the recipe will be added successfully
    

    
   Scenario Outline: The user let the title blank
    When the user enter "<title>" in title field
    And the user enter "<userName>" in user name field
    And the user enter "<description>" in description field
    And the user enter "<ingrediants>" in ingrediants field
    And the user enter "<time>" in time field
    Then the massage "<msg>" will displayed on screen

    Examples: 
      | title  | userName | description  | ingrediants |time | msg |
      |  | shams_aziz | just a standerd pizza | salami, salt, tomato | 10|  please enter a title!|
      | pizza | shams_aziz | just a standerd pizza | | 10|  please enter the ingrediants! |
      | pizza |  | just a standerd pizza | salami, salt, tomato | 10|  please enter your user name! |