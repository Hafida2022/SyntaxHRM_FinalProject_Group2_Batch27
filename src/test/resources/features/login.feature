Feature: Login functionality

  @login
  Scenario: Valid user login
    Given the user is on the SyntaxHRM login page
    When the user enters a valid username
    And the user enters a valid password
    And the user clicks on the login button
    Then the user should successfully navigate to the dashboard