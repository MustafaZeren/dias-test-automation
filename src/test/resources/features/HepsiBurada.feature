Feature: Category Navigation
  Scenario: Navigate to a specific category
    Given Open main page
    When Navigate to category
    When Select "Apple" category from left side menu
    When Find the most expensive product
    When Add to cart
    When Go to cart
    Then Check price from the cart