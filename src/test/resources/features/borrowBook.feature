Feature: borrowBook


  @B26G16-73
  Scenario: Student should be able to borrow a book
    Given student is on homePage
    When student clicks Borrow Book button of any available book
    Then student's name should be on the Borrowed By of selected book
    And Borrow Book button should be disabled