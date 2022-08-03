package com.cydeo.step_def;

import com.cydeo.pages.LibraryCTBookPage;
import com.cydeo.pages.LibraryCTLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LibraryCTStepDefinitions {

    LibraryCTLoginPage libraryCTLoginPage = new LibraryCTLoginPage();
    LibraryCTBookPage libraryCTBookPage = new LibraryCTBookPage();

    @Given("librarian is on the loginPage")
    public void librarian_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("librarian enters valid credentials and clicks sign in button")
    public void librarian_enters_valid_credentials_and_clicks_sign_in_button() {
        libraryCTLoginPage.login(ConfigurationReader.getProperty("usernameLi"), ConfigurationReader.getProperty("passwordLi"));
    }
    @Given("librarian is on homePage")
    public void librarian_is_on_home_page() {
        BrowserUtils.waitForTitle("Library");
        BrowserUtils.verifyTitle("Library");
    }
    @When("librarian clicks Books module")
    public void librarian_clicks_books_module() {

        libraryCTBookPage.booksModuleBtn.click();
    }
    @When("librarian clicks +Add Book button")
    public void librarian_clicks_button() {
        libraryCTBookPage.addBookBtn.click();
    }
    @When("librarian enters BookName, ISBN, Year,Author and Description")
    public void librarian_enters_book_name_isbn_year_author_and_description() {
        BrowserUtils.waitForClickable(libraryCTBookPage.bookNameBox);
        libraryCTBookPage.bookNameBox.sendKeys("Eating Cucumbers 2: More Cucumbers");
        libraryCTBookPage.isbnBox.sendKeys("98777");
        libraryCTBookPage.yearBox.sendKeys("2021");
        libraryCTBookPage.authorBox.sendKeys("Aysun");
        libraryCTBookPage.descriptionBox.sendKeys("Cucumber is really fun!");
    }
    @When("librarian clicks save changes")
    public void librarian_clicks_save_changes() {
        libraryCTBookPage.saveChangesBtn.click();
    }
    @Then("verify a new book is added")
    public void verify_a_new_book_is_added() {
        Assert.assertTrue("Book created confirmation message has not appeared", libraryCTBookPage.bookCreatedMessage.isDisplayed());

        System.out.println(libraryCTBookPage.bookCreatedMessage.getText());
    }



    @Given("user is on the loginPage")
    public void user_is_on_the_login_page() {
         {Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        }
    }
    @When("user enter invalid email or password")
    public void user_enter_invalid_email_or_password() {
        libraryCTLoginPage.login("student", "368383414486M");

    }
    @When("student click sign in button")
    public void student_click_sign_in_button() {
libraryCTLoginPage.signInBtn.click();
    }
    @Then("verify the error message {string}")
    public void verify_the_error_message(String string) {

Assert.assertTrue(libraryCTLoginPage.alertMsg.isDisplayed());
    }


}
