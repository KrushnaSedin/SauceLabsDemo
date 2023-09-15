Feature: To test Add to cart functionality

  Scenario Outline: User should be able to add single product to the cart
    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    And add single product to the cart
    Then Item should get added to the cart

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
  Scenario Outline: User should be able to add multiple products to the cart
    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    And add multiple product to the cart
    Then All items should get added to the cart

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Remove button should appear after adding product to the cart
    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    And add single product to the cart
    Then Remove button should appear

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
