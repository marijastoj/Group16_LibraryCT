Feature: As a librarian, I should be able to add a new user.


  @B26G16-67
  Scenario: As a librarian, I should be able to add a new user.
Given librarian is on the homePage
When librarian click users module
And librarian click add user button
When librarian enter full name, password, email and address
And librarian click save changes
Then verify a new user is created