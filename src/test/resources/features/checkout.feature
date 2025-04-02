@group3
Feature: Checkout Process
  Scenario: Add Item to Cart
    Given I am viewing a product
    When I add the product to the cart
    Then The cart count should increase by 1

  Scenario: Checkout as Guest
    Given I have items in my cart
    When I checkout as a guest
    Then I should see the payment page