Feature: The Admin view and delete feedback

  Scenario: View feedback information
    Given The user role is "Admin" 
    When the Admin is logged in  
    Then the Admin can see all feedback

  Scenario: The Admin deletes feedback successfully
    Given The user role is "Admin"
    When the Admin is logged in  
    And the Admin wants to delete feedback with username "bayan" on product "Chocolate Cake"
    Then the feedback with username "bayan" on product "Dark Chocolate" should be successfully deleted

  Scenario: The Admin enters an invalid username
    Given The user role is "Admin"
    When the Admin is logged in  
    And the Admin wants to delete feedback with username "non-existent" on product "Dark Chocolate"
    Then an error message should appear "the feedback does not exist"

  Scenario: The Admin enters an invalid product
    Given The user role is "Admin"
    When the Admin is logged in   
    And the Admin wants to delete feedback with username "bayan" on product "non-existent"
    Then an error message should appear "the feedback does not exist"

  Scenario: The Admin leaves the username field empty
    Given The user role is "Admin"
    When the Admin is logged in  
    And the Admin wants to delete feedback with username "" on product "Chocolate Cake"
    Then an error message should appear "the username field is empty"

  Scenario: The Admin leaves the product field empty
    Given The user role is "Admin"
    When the Admin is logged in  
    And the Admin wants to delete feedback with username "bayan" on product ""
    Then an error message should appear "the product field is empty"
