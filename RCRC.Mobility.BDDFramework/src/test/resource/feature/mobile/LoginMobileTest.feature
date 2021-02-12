
Feature: Verfiy sign In to Liferay through Android 

@SmokeTests
    Scenario: TC001_Successfully login to mobile application
    Given I am able to launch appium
    When user enter credentials    
    And user click login
    Then I validate the outcomes   
  
