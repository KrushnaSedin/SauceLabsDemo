Feature: Test login functionality
  Scenario Outline: User should able to login

    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    Then user should be successfully logged in

    Examples:
    |username|password|
    |standard_user|secret_sauce|