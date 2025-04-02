@group2
Feature: Product Search
  Scenario: Search by Product Name
    Given I am on the homepage
    When I search for "laptop"
    Then I should see at least 5 results

  Scenario: Empty Search
    Given I am on the homepage
    When I search for ""
    Then I should see a warning message "Please enter a search term"