Feature: Verify Get method using the Brearer Authentication Tokens for Weather Utilities

@SmokeTests
Scenario: TC001_Verify GET operation for Weather Utilities
 Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for  Weather Utilites "/utilities-weather/1.0.0/weather"
     Then I should see statuscode as "HTTP/1.1 200 OK"