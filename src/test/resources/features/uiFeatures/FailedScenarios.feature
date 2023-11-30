@failed_scenarios
Feature:  User Login without Credentials
  The user should not be able to log in to the application without providing valid credentials.

  Background: Student goes to homepage and clicks on the register link
    Given student navigates to homepage
    And clicks on the "Register" link from the homepage

  Scenario Outline: Scenario 3_Registration with invalid email

    Given the student is on the register page
    When enters a valid first name
    And user enters an invalid email address "<invalid email address>"
    And enters a valid web address
    And enters an interest
    And enters a valid password
    And confirms the password
    And clicks on the register button
    Then verify invalid email address alert is seen
    Then close the application

    Examples: test invalid email addresses
      | invalid email address |
      |                       |
      | 123                   |
      | test                  |
      | test@                 |
      | test@co               |

  Scenario Outline: Scenario 4_Registration with passwords that match but fewer than 8 characters including blank

    Given the student is on the register page
    When enters a valid first name
    And enters a valid email address
    And enters a valid web address
    And enters an interest
    And user enters invalid characters in "<password>" and "<confirm password>" fields
    And clicks on the register button
    Then verify alert for password must be longer is seen
    Then close the application

    Examples: test password
      | password | confirm password |
      |          |                  |
      | a        | a                |
      | 1        | 1                |
      | 1ab      | 1ab              |
      | abc      | abc              |

  Scenario Outline: Scenario 5_Registration with invalid web address

    Given the student is on the register page
    When enters a valid first name
    And enters a valid email address
    And user enters an invalid web address "<invalid web address>"
    And enters an interest
    And enters a valid password
    And confirms the password
    And clicks on the register button
    Then close the application

    Examples: test invalid web addresses
      | invalid web address |
      | google              |
      | google.com          |
      | www.google.com      |
      | ps://www.google.com |



  Scenario: Scenario 6_Registration with only interests field filled

    Given the student is on the register page
    And enters an interest
    And clicks on the register button
    Then verify alert for email, password fields must be entered
    Then close the application

