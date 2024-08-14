
Feature: Tracking orders status


  Scenario: Process a pending order
  Given the user role is "Owner" and the user name "shams_imad"
  When the orders list is not empty
  Then the system should handle the orders with "on pending" status correctly
  
  
   Scenario: Process a delivered  order
  Given the user role is "Owner" and the user name "shams_imad"
  When the orders list is not empty
  Then the system should handle the orders with "on delivered" status correctly
  
    Scenario: Process an order that is being processed
  Given the user role is "Owner" and the user name "shams_imad"
  When the orders list is not empty
  Then the system should handle the orders with "on processing" status correctly
  
    Scenario: Process a cancelled  order
  Given the user role is "Owner" and the user name "shams_imad"
  When the orders list is not empty
  Then the system should handle the orders with "cancelled" status correctly
  
  
  Scenario: Handle an unknown order status
  Given the user role is "Owner" and the user name "shams_imad"
  When the orders list is not empty
  Then the system should handle the orders with "unknown" status correctly
  And an error message should appear "please write a valid status!"
  
  Scenario: Process an order from non owner or supplier
  Given the user role is "User" and the user name "ahmad"
  Then an error message should appear "You can't handle the orders!"
  
   
  