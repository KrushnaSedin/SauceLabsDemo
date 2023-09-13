Feature: To locate all products
  Scenario: To list out all product names

    Given user is on login page
    When user login with valid username and passsword
    Then user should see list of 6 products