Feature: To test Add to cart functionality

  Scenario Outline: User should be able to add single product to the cart
    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    And he added single product to the cart
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
    And he added single product to the cart
    Then Remove button should appear

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Remove button should remove item from cart
    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    And he added single product to the cart
    And then remove product from the cart
    Then Cart should be empty

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: User should be successfully taken to the cart
    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    And he added single product to the cart
    And he go to the cart
    Then added prdocut should be there in the cart

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: User should be able to continue shopping afetr adding items to cart
    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    And he added single product to the cart
    And he go to the cart
    Then he opt to go back to shopping
    Then user should be able to go back for shopping

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: User should be able to navigate to Checkout screen
    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    And he added single product to the cart
    And he go to the cart
    Then he opt to for Checkout option
    Then user should navigate to Checkout screen

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Menu bar should show list of options
    Given user wants to try to login to saucedemo
    When he provides credentials <username> as username and <password> as password
    And he added single product to the cart
    And he go to the cart
    Then he opt to for Checkout option
    When he selects menu bar
    Then under menu bar there should be list of options

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
