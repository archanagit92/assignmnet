#Author: your.email@your.domain.com
@regression
Feature: Adding items to cart

  Background: User is LogIn and checks if cart is empty
    Given user navigate to the login page
    When user submit username and password
    Then user validate home page title sucessfully
      | title          |
      | Amazon Sign In |
    Then user click on cart
    Then user delete the itmes from cart if exists

  @regression
  Scenario Outline: Adding a <productList> Item in Cart and verifying sub total
    Given user search for the products and add items to cart
      | productList   | productPosition   |
      | <productList> | <productPosition> |
    Then user click on cart
    When user verify subTotal price

    Examples: 
      | productList         | productPosition |
      #     | monitor             |             1 |
      #    | Laptop              |             2 |
      | Headphones,Keyboard |             1,1 |
