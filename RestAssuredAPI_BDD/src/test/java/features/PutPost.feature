Feature: PUT Post

Scenario: Verify PUT operatiob after POST operation
Given I perform post operation for "/posts" with body to test PUT
	|	id	|	title								|	author				|
	|	7		|	API Automation Testing Course	|	Apurva Barot	|
And I perform PUT operation for "/posts/{postid}"
	|	id	|	title									|	author				|
	|	7		|	API Automation Course	|	Barot Apurva	|
And I perform GET operation with path parameters for "/posts/{postid}"
	|	id	|
	|	7		|
Then I should see the body with title "API Automation Course"