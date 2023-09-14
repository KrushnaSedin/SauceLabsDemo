Feature: Test login functionality
  Scenario Outline: User should able to login

    Given user is on login portal
    When user login with valid credentials <username> and <password>
    Then user should succesfully login

    Examples:
    |username|password|
    |standard_user|secret_sauce|
#    |problem_user |secret_sauce|