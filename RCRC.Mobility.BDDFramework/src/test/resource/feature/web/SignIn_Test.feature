Feature: Verify Sign In to Liferay Web Portal

  @SmokeTests
   Scenario: TC001_Successful Sign In with Valid Credentials
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters UserName and Password
    Then Message displayed Login Successfully
    
