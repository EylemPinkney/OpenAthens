@E2E_US01
Feature: Registration
  The user should be able to log in to the application with providing valid credentials

  Background: Student goes to homepage and clicks on the register link
    Given student navigates to homepage
    And clicks on the "Register" link from the homepage

  Scenario: Scenario 1_Successful registration with all correct credentials

    Given the student is on the register page
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

  #@DB01_TC01

  #Scenario Outline: Validate student can see ...
   #Given connect to database
    #When get student via username "<username>"
    #Then validate ...
    #And close the connection


    #Examples:
      #| name  | email  |
      #| ... | ...  |

  #@API01-TC01 @Api_admin

  #Scenario: Validate that the student has successfully registered with all correct credentials

    #Given valid student details, endpoint URL, and request body
    #When a POST request, with a request body that includes valid student credentials, is sent to the endpoint
    #And the response will be received with status code 201
    #Then verify the response body has correct student details



