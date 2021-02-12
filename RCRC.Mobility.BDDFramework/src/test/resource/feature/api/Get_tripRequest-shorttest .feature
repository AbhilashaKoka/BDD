Feature: Verify Get method using the Brearer Authentication Tokens for tripRequest-shorttest-leasttime

@SmokeTests
Scenario: TC001_Verify GET operation for tripRequest-shorttest-leasttime with bearer authentication token
    Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for  tripRequest-shorttest-leasttime "/trip/1.0.0/XML_TRIP_REQUEST2"
     Then I should see statuscode as "HTTP/1.1 200 OK"
     
     
 @SmokeTests    
 Scenario: TC002_Verify GET operation for tripRequest-shorttest-leastWalking with bearer authentication token
 Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     When I perform GET operation for  tripRequest-shorttest-leastWalking "/planning-trip/1.0.0/trip"
     Then I should see statuscode as "HTTP/1.1 200 OK"
     
     
     
     
     
     