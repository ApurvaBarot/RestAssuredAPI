Feature: Delete Post

Scenario: Verify DELETE operatiob after POST operation
Given I perform post operation for "/posts" with body as 
	|	id	|	title								|	author				|
	|	6		|	API Testing Course	|	Apurva Barot	|
And I perform DELETE operation for "/posts/{postid}"
|	postid	|
|	6				|
And I perform GET operation with path parameter for "/posts/{postid}"
|	postid	|
|	6				|
Then I should not  see the body with title as "API Testing Course"