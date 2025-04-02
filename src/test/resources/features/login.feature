Feature: Login functionality
  Scenario: Successful login
    Given I navigate to the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should see the dashboard

    # Example: Tag 2 scenarios per group
#  @group1
#  Feature: User Login Validation
#  Scenario: Successful Login
#    Given I navigate to the login page
#    When I enter valid username "testuser" and password "Password123"
#    Then I should see the dashboard

#  Scenario: Invalid Login
#    Given I navigate to the login page
#    When I enter invalid username "wronguser" and password "WrongPass"
#    Then I should see an error message "Invalid credentials"