Feature: To check total number of products

  Scenario Outline: To list out all product names

    Given user is on saucedemo login portal
    When user login on saucedemo with valid credentials <username> and <password>
    Then user should see list of 6 products

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: To check filter functionality

    Given User is on login portal
    When User login with valid credentials <username> and <password>
    And User filtered out the products from low to high prices
    Then User should see products in ascending order of prices

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |