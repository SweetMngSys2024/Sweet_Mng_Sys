

Feature: Send Msgs from Owner 

       Scenario: Owner wants to sent a massage for a user
    When user write "ahmad" in the uNameDest field
    And user enter "it is a Massage!" in the msg field in send massage page
    And user write "User" in the typeOfDest field
    Then the massage will sent to the destenation
    
       Scenario: Owner wants to sent a massage for a supplier
    When user write "rama" in the uNameDest field
    And user enter "it is a good work!" in the msg field in send massage page
    And user write "Supplier" in the typeOfDest field
    Then the massage will sent to the destenation
    
  
      Scenario: Owner wants to sent a massage with invalid uNameDest
    When user write "hasan" in the uNameDest field
    Then the error "please fill the valid user name!" will displayed on screen
    
      Scenario: Owner wants to sent a massage with blank uNameDest
    When user write "" in the uNameDest field
    Then the error "please fill the valid user name!" will displayed on screen
    
    
       Scenario: Owner wants to sent a massage with blank typeOfDest
    When user write "ahmad" in the uNameDest field
    And user enter "it is a good msg!" in the msg field in send massage page
    And user write "" in the typeOfDest field
    Then the error "please fill the valid type!" will displayed on screen
    
      Scenario: Owner wants to sent a massage with invalid typeOfDest
    When user write "ahmad" in the uNameDest field
    And user enter "it is a good msg!" in the msg field in send massage page
    And user write "invalid type" in the typeOfDest field
    Then the error "please fill the valid type!" will displayed on screen  
    
    
         Scenario: Owner wants to sent a massage with blank msg
    When user write "ahmad" in the uNameDest field
    And user enter "" in the msg field in send massage page
    And user write "User" in the typeOfDest field
    Then the error "please write a massage!" will displayed on screen  
    
