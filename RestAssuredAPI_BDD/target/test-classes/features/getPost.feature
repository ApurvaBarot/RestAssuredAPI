Feature: 
	Verify different GET operations using REST-Assured
	
	Scenario: Verify one author of the post
	Given I perform GET operation for "/posts/1"
	Then I should see the author name as "Apurva"
	
	#Scenario: Verify one author of the post
	#Given I perform GET operation for "/posts"
	#And I perform  GET for the post nuber "1"
	#Then I should see the author name as 
	

	#	Scenario: Verify path parameter of GET
	#	Given I perform GET operation for "/posts"
	#	Then I should verify GET path parameters 
	
	#Scenario: Verify query parameter of GET
	#Given I perform GET operation for "/posts"
	#Then I should verify GET query parameters 
	
	
	
 
 