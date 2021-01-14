#Author: mohitjangra07@gmail.com
@uiTest
Feature: I want verify the Demo Store

  @Test
  Scenario Outline: I am able to navigate through product categories
    Given I am on the homepage
    When I select the "<category>" from Homepage
    And I select product from available product cards
      | product      |
      | Sony vaio i5 |
    And I click on Add to Cart button and accept the popup
    And I click Home menu on the home page
    And I select the "<category>" from Homepage
    And I select product from available product cards
      | product     |
      | Dell i7 8gb |
    And I click on Add to Cart button and accept the popup
    And I Open the cart
    And I delete the product from cart
      | product     |
      | Dell i7 8gb |
    And I click on Place Order
    And Fill the form with "<name>" "<country>" "<city>" "<creditCard>" "<month>" "<year>" and click Purchase
    Then I validate the purchase Amount is as expected and click Ok


    Examples:
      | category | name | country | city  | creditCard       | month | year |
      | Laptops  | Test | India   | Delhi | 1234000012340000 | Jan   | 2021 |

