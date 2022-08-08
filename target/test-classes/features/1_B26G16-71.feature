Feature: Default

	Background:
		#@B26G16-69
		    Given librarian is on the loginPage
		    When librarian enters valid credentials and clicks sign in button

	
	@B26G16-71 @B26G16-63
	Scenario: As a librarian, I should be able to add a new book
		Given librarian is on homePage
		When librarian clicks Books module
		And librarian clicks +Add Book button
		When librarian enters BookName, ISBN, Year,Author and Description
		And librarian clicks save changes
		Then verify a new book is added