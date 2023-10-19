Feature: To check Filter Functionality

  Scenario Outline: To list out all from high to low prices
    Given user wants to try to login to saucedemo
    When he provides valid credentials <username> as username and <password> as password
    And User filtered out the products from high to low prices
    Then User should see products in descending order of prices

    Examples:

      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: To list out all from low to high prices
    Given user wants to try to login to saucedemo
    When he provides valid credentials <username> as username and <password> as password
    And User filtered out the products from low to high prices
    Then User should see products in ascending order of prices

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: To list out all products in alphabetical order
    Given user wants to try to login to saucedemo
    When he provides valid credentials <username> as username and <password> as password
    And User filtered out the products alphabetically
    Then User should see products in alphabetical order of names

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: To list out all products in reverse alphabetical order
    Given user wants to try to login to saucedemo
    When he provides valid credentials <username> as username and <password> as password
    And User filtered out the products reverse alphabetically
    Then User should see products in reverse alphabetical order of names

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |