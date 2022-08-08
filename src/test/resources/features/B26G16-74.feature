Feature: User should be able to borrow a book

	
	@B26G16-74 @B26G16-63 @wip123
	Scenario: Student should be able to borrow a book
		Given student is on homePage
		When student search for the books in the list below
		And student finds the book which is avaliable
		Then student clicks Borrow Book button
		Then student should be able to borrow