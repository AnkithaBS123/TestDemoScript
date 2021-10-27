Feature: Test Script Demo

  Scenario: Automating Demo Shop

    Given I add four different products to my wishlist
    When I view my wishlist table
    Then I find total four selected items in my wishlist
    When I search for lowest price item to my cart
    Then I am to verify the item in my cart