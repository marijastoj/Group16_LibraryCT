Feature: Default

	
	@B26G16-65
		Scenario: As a user, I should be able to login to LibraryCT. 
		Given student is on the loginPage 
		Then verify that the URL is "https://library2.cydeo.com/login.html" 
		When student enters valid email address and password 
		And student click sign in button 
		Then verify that there are 2 models on the page