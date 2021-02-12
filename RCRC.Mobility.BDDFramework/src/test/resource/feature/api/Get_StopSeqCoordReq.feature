Feature: Verify Get method using the Brearer Authentication Tokens for StopSeqCoordReq

@SmokeTests
Scenario: Get the StopSeqCoord

Given I perform authentication operation for "/token" with body
     |grant_type | username       | password |
     |password   | apisubscriber  | apisubscriber |
     When I perform GET operation for get the StopSeqCoord "/planning-stopseqcoord/1.0.0"
     Then I should see statuscode as "HTTP/1.1 200 OK"