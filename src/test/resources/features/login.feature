Feature: Login functionality
  Scenario: Successful login
    Given I navigate to the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should see the dashboard