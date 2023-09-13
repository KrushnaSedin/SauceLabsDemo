Feature: Test login functionality
  Scenario Outline: Check whether login functionality work fine

    Given user is on saucedemo login page
    When user enters valid <username> and <password> for saucedemo
    Then user should succesfully redirected to saucedemo homepage

    Examples:
    |username|password|
    |standard_user|secret_sauce|
    |problem_user |secret_sauce|