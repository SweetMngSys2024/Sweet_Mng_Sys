Feature: User login sweet

  Scenario Outline: Login with different credentials
    Given user is not in the sweet system
    When user logs in with username "<username>" and password "<password>" and role "<role>" logs in
    Then the login result should be "<expected_result>"

    Examples:
      | username   | password     | role      | expected_result         |
      | bayan      | password123  | User      | logged_in               |
      | bayan      | Wrong123     | User      | failed_login_password   |
      | wrongbayan | password123  | User      | failed_login_username   |
      | aya        | password789  | Admin     | logged_in               |
      | aya        | Wrong789     | Admin     | failed_login_password   |
      | wrongaya   | password789  | Admin     | failed_login_username   |
      | shams      | password654  | Owner     | logged_in               | 
      | shams      | Wrong654     | Owner     | failed_login_password   |
      | wrongshams | password654  | Owner     | failed_login_username   |
      | rama       | password675  | Suppliers | logged_in               |
      | rama       | Wrong675     | Suppliers | failed_login_password   |
      | wrongrama  | password675  | Suppliers | failed_login_username   |
      
  Scenario Outline: User left username or password field blank 
    Given user is not in the sweet system 
    When user logs in with username "<username>" and password "<password>" and role "<role>" logs in
    Then an error message should appear "<error_message>"

    Examples:
      | username | password | role | error_message                 |
      |          | password | User | please enter your username     |
      | username |          | User | please enter your password     |




