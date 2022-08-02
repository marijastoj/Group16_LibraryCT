Feature: Default


  @B26G16-66 @B26G16-63
  Scenario: As a student, I should not be able to login to LibraryCT with invalid credentials.
    Given user is on the loginPage
    When user enter invalid email or password
    And student click sign in button
    Then verify the error message "Sorry, Wrong Email or Password"