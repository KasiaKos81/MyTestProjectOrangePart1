Feature: Login as admin using incorrect credentials

As an Admin I want to check what happens if I log in with incorrect credentials

  Scenario Outline: Login with incorrect credentials
    Given User is on the login page
    When User enters login <loginek>
    And User enters password <passwordzik>
    And User clicks on Login button
    Then User is not logged in
    And Information about invalid credentials is displayed

    Examples:
    | loginek | passwordzik |
    | AdminAdmin | admin123 |
    | Admin      | admin125 |
    | AdminAdmin | admin125 |





