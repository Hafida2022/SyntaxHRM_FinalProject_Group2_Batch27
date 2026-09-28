Feature: Login validation

  Background:
    Given the user is on the SyntaxHRM login page

  Scenario: Login with valid credentials
    When the user enters a valid username
    And the user enters a valid password
    And the user clicks on the login button
    Then the user should successfully navigate to the dashboard

  Scenario: Login with correct username and wrong password
    When the user enters a valid username
    And the user enters an invalid password
    And the user clicks on the login button
    Then the user should see the invalid credentials message

  Scenario: Login with correct username and empty password
    When the user enters a valid username
    And the user clicks on the login button
    Then the password required message should be displayed

  Scenario: Login with empty username and valid password
    When the user enters a valid password
    And the user clicks on the login button
    Then the username required message should be displayed

  Scenario: Login with empty username and empty password
    When the user clicks on the login button
    Then required messages should be displayed for username and password

  Scenario: User can retry login after invalid credentials
    When the user enters a valid username
    And the user enters an invalid password
    And the user clicks on the login button
    Then the user should see the invalid credentials message
    And the user should remain on the login page
    When the user enters a valid username
    And the user enters a valid password
    And the user clicks on the login button
    Then the user should successfully navigate to the dashboard