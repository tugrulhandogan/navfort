@PERF-1458
Feature: User should be able to login

  Background:
#    Given The user is on the login page

  @PERF-1502
  Scenario Outline: Testing the login functionality for Truck Driver with valid credentials
    When User enters valid "<username>" and "<password>"
    And User clicks to login button
    Then User should be able to land on the "Quick Launchpad" page
    Examples:
      | username | password    |
      | user1    | UserUser123 |
      | user5    | UserUser123 |

  @PERF-1511
  Scenario Outline: Testing the login functionality for Truck Driver with invalid credentials
    When User enters invalid "<username>" and "<password>"
    And User clicks to login button
    Then User should not be able to land on the Quick Launchpad page
    Examples:
      | username | password    |
      | 2342566  | UserUser123 |

  @PERF-1541
  Scenario Outline: Testing the login functionality for Store Manager with valid credentials
    When When User enters valid "<username>" and "<password>"
    And User clicks to login button
    Then User should be able to land on the Dashboard page
    Examples:
      | username       | password    |
      | storemanager71 | UserUser123 |

  @PERF-1542
  Scenario Outline: Testing the login functionality for Sales Manager with valid credentials
    When User enters valid "<username>" and "<password>"
    And User clicks to login button
    Then User should be able to land on the Dashboard page
    Examples:
      | username        | password    |
      | salesmanager121 | UserUser123 |

  @PERF-1543
  Scenario: Testing if users would not allowed to login without provide credentials
    When User tries to login without provide credentials
    And User clicks to login button
    And User should see the "Please fill out this field." message
    Then User should be on the login page without be able to login

  @PERF-1544
  Scenario Outline:  Testing if users should see "Invalid username or password" message after invalid credentials.
    When User enters valid "<username>" and "<password>"
    And User clicks to login button
    Then User should see "Invalid user name or password." message
    Examples:
      | username    | password |
      | user92935.? | aaaaaa   |

  @PERF-1545
  Scenario Outline:  Testing the "Forgot Password" menu
    When User clicks the Forgot your password link
    And User enters the "<Username or Email>" credentials
    And User clicks the Request button
    Then User should not see "Unable to send the email." message
    Examples:
      | Username or Email |
      | user5             |
      | salesmanager111   |
      | storemanager71    |

  @1234
  Scenario Outline: Testing - "Remember me on this computer" checkbox
    Given The user is on the login page

    When User enters valid "<username>" and "<password>"
    And user clicks the Remember me on this computer checkbox
    And user click to login button
    And user closes the tab and opens new tab
    Then user should be able to login again without entering credentials

    Examples:
      | username | password    |
      | user1    | UserUser123 |
#     | salesmanager111 | UserUser123 |
#  | storemanager71  | UserUser123 |
#










