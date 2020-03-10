Narrative:
As a QA
I want to check a valid user's profile on github
So that github would respond json data

Scenario: testing media type
Given github profile
When I searche for a user as <user>
Then github respond data of type json <json>

Examples:
|user  |json|
|edenjp|application/json|