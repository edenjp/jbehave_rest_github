Narrative:
As a QA
I want to check a valid user's profile on github
So that github's response json should include the same username and his id

Scenario: testing JSON payload
Given github profile
When I search for a user as <user>
Then I should get the response with the same username <username>
And the id <id> of the user

Examples:
|user    |username  |id        |
|edenjp  |edenjp    |4104705   |