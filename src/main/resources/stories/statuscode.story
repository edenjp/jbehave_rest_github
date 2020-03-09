Narrative:
As a QA
I want to test the Rest API of GitHub
So that I can check if a user exist or not

Scenario: testing status code
Given a github user profile api
When I search for a user <user> via the api
Then I should get status code as <statuscode>

Examples:
|user      |statuscode|
|edenjp    |200       |
|the_monio |404       |