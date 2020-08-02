Feature: Verify complex Data GET operation

Scenario: Verify GET operation for complex data
	Given I perform GET opeation with path param for address "/location/"
		|id |
		| 1	|
	Then I should see the street name as "S V Road" for the "primary" address
	