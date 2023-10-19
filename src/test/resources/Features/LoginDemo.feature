Feature: Test login functionality
  Scenario Outline: User should able to login

    Given user wants to try to login to saucedemo
    When he provides valid credentials <username> as username and <password> as password
    Then user should be successfully logged in

    Examples:
    |username|password|
    |standard_user|secret_sauce|

  Scenario Outline: User should not be able to login when they provide invalid credentials

    Given user wants to try to login to saucedemo
    When he provides valid credentials <username> as username and <password> as password
    Then user should not be logged in

    Examples:
      |username|password|
      |standard_user|fdgfgdfgdf|