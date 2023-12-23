@passed_scenarios
Feature: Registration
  The user should be able to log in to the application with providing valid credentials

  Background: Student goes to homepage and clicks on the register link
    Given student navigates to homepage
    And clicks on the "Register" link from the homepage

  Scenario: Scenario 1_Successful registration with all correct credentials

    Given the student is on the register page now
    When enters a valid first name
    And enters a valid email address
    And enters a valid web address
    And enters an interest
    And enters a valid password
    And confirms the password
    And clicks on the register button
    Then verify that register is successful with personalized greeting is displayed
    Then verify that a list of 5 job vacancies is displayed on the Dashboard Page
    Then close the application

  Scenario Outline: Scenario 2_Registration with mismatch password

    Given the student is on the register page now
    When enters a valid first name
    And enters a valid email address
    And enters a valid web address
    And enters an interest
    And user enters invalid characters in "<password>" and "<confirm password>" fields
    And clicks on the register button
    Then verify alert for passwords did not match is seen
    Then close the application

    Examples: test password
      | password   | confirm password |
      | a          |                  |
      | 1          |                  |
      | a          | 1                |
      | abc        | ab1              |
      | 0123456789 | 12345678         |
      | abcdefgh   | abcdefg@         |








