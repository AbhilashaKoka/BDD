
Feature: Verify Get method using the Brearer Authentication Tokens for TripStopTime


@SmokeTests
Scenario: Get the Tripcode, stopId, line time and date using the Trip-Request

Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for get the Tripcode, stopId, line time and date "/planning-trip/1.0.0/trip"
     Then I should see statuscode as "HTTP/1.1 200 OK"



Scenario: get the stop sequence, including arrival and departure-times
Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for get the stop sequence, including arrival and departure-times "/planning-tripstoptime/1.0.0/tripstoptime"
     Then I should see statuscode as "HTTP/1.1 200 OK"



Scenario: filter the stop sequence.
Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for  get filter the stop sequence "/planning-tripstoptime/1.0.0/tripstoptime"
     Then I should see statuscode as "HTTP/1.1 200 OK"