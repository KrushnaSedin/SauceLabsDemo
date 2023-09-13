Feature: To locate all products

  Scenario Outline: To list out all product names

    Given user is on saucedemo loginpage
    When user login on saucedemo with valid <username> and <password>
    Then user should see list of 6 products

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  Scenario Outline: To check filter functionality

    Given User is on login portal
    When User login with valid credentials <username> and <password>
    And User filtered out the products from Z toA
    Then User should see 1 st product Tshirt Red

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |