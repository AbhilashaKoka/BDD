Feature: Verify Get method using the Brearer Authentication Tokens for tripRequest-fastest

@SmokeTests
Scenario: TC003_Verify GET operation for tripRequest-fastest-fastestslow with bearer authentication token
    Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for  fastest slow "/planning-trip/1.0.0/trip"
     Then I should see statuscode as "HTTP/1.1 200 OK"
     
     
     
 Scenario: TC004_Verify GET operation for tripRequest-fastest-fastestfast with bearer authentication token
 Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for  fastest fast "/planning-trip/1.0.0/trip"
     Then I should see statuscode as "HTTP/1.1 200 OK"
     
     
     Scenario: TC005_Verify GET operation for tripRequest-fastest-departureTime with bearer authentication token
 Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for  departure Time "/planning-trip/1.0.0/trip"
     Then I should see statuscode as "HTTP/1.1 200 OK"
     
     
     Scenario: TC006_Verify GET operation for tripRequest-fastest-arrivalTime with bearer authentication token
 Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for  arrival Time "/planning-trip/1.0.0/trip"
     Then I should see statuscode as "HTTP/1.1 200 OK"
     
     
     
     
     
     