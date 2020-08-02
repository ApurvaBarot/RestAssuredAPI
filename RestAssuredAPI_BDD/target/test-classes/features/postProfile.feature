Feature: Verify POST feature on profile

#Scenario: Verify Post operation
	#Given I perform the post operation
 
 Scenario: Verify post operation for profile
 Given I perform post operation for "/posts/{profileNo}/profile" with body
 		| name 			| profile	|
 		| Kriyansh3 	| 3				|
 Then I should see the body has name as "Kriyansh3"