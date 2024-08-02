Feature: Send a feedback or massage 
  

  Scenario: User wants to set a feedback with vaild inputs
    When user write "Recipe" in type field
    And user enter "it is a good recipe!" in msg field
    And user write "Chocolate Cake" in product or recipe name field
    Then the feedback will be raised to the admin
   
  Scenario: User wants to set a feedback with invaild type
    When user write "Pizza" in type field
    And user enter "it is a good recipe!" in msg field
    And user write "Chocolate Cake" in product or recipe name field
    Then the error "please write only Recipe or Product!" will displayed on screen
    
  Scenario: User wants to set a feedback with invaild name
    When user write "Product" in type field
    And user enter "it is a very nice product!" in msg field
    And user write "Hot Chocolate" in product or recipe name field
    Then the error "please write correct name!" will displayed on screen
     
   
   Scenario: User wants to set a feedback with blank type
    When user write "" in type field
    And user enter "it is a good product!" in msg field
    And user write "Dark Chocolate" in product or recipe name field
    Then the error "please fill the type field!" will displayed on screen
    
   Scenario: User wants to set a feedback with blank name
    When user write "Recipe" in type field
    And user enter "it is a good recipe!" in msg field
    And user write "" in product or recipe name field
    Then the error "please fill the name field!" will displayed on screen
    
    
  Scenario: User wants to set a feedback with blank msg
    When user write "Product" in type field
    And user enter "" in msg field
    And user write "Dark Chocolate" in product or recipe name field
    Then the error "please fill the msg field!" will displayed on screen
    
    
Scenario: User wants to sent a massage with blank msg
    When user write "Branch 1" in uNameDest field
    And user enter "" in msg field in send massage page
    And user write "Owner" in typeOfDest field
    Then the error "please fill the msg field!" will displayed on screen
    
    Scenario: User wants to sent a massage with blank uNameDest
    When user write "" in uNameDest field
    And user enter "it is a good branch!" in msg field in send massage page
    And user write "Owner" in typeOfDest field
    Then the error "please fill the branch name field!" will displayed on screen
    
      Scenario: User wants to sent a massage with invalid uNameDest
    When user write "Branch 5" in uNameDest field
    And user enter "it is a good branch!" in msg field in send massage page
    And user write "Owner" in typeOfDest field
    Then the error "please fill the valid branch name!" will displayed on screen
    
    
  Scenario: User wants to sent a massage with invalid typeOfDest
    When user write "Branch 1" in uNameDest field
    And user enter "it is a good branch!" in msg field in send massage page
    And user write "User" in typeOfDest field
    Then the error "please fill the valid type!" will displayed on screen
    
      Scenario: User wants to sent a massage with blank typeOfDest
    When user write "Branch 1" in uNameDest field
    And user enter "it is a good branch!" in msg field in send massage page
    And user write "" in typeOfDest field
    Then the error "please fill the valid type!" will displayed on screen
    
       Scenario: User wants to sent a massage
    When user write "Branch 1" in uNameDest field
    And user enter "it is a good branch!" in msg field in send massage page
    And user write "Owner" in typeOfDest field
    Then the massage will sent to the dst
    
    
    
    
    
    