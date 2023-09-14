Feature: To check Filter Functionality

  Scenario Outline: To list out all from high to low prices
    Given User is on login portal
    When User login with valid credentials <username> and <password>
    And User filtered out the products from high to low prices
    Then User should see products in descending order of prices

    Examples:

      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: To list out all from low to high prices
    Given User is on login portal
    When User login with valid credentials <username> and <password>
    And User filtered out the products from low to high prices
    Then User should see products in ascending order of prices

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: To list out all products in alphabetical order
    Given User is on login portal
    When User login with valid credentials <username> and <password>
    And User filtered out the products alphabetically
    Then User should see products in alphabetical order of names

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: To list out all products in reverse alphabetical order
    Given User is on login portal
    When User login with valid credentials <username> and <password>
    And User filtered out the products reverse alphabetically
    Then User should see products in reverse alphabetical order of names

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |