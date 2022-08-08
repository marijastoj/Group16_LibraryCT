package com.cydeo.step_def;

import com.cydeo.pages.LibraryCTBasePage;
import com.cydeo.pages.LibraryCTBookPage;
import com.cydeo.pages.LibraryCTBorrowingBooks;
import com.cydeo.pages.LibraryCTLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LibraryCTStepDefinitions {

    LibraryCTLoginPage libraryCTLoginPage = new LibraryCTLoginPage();
    LibraryCTBookPage libraryCTBookPage = new LibraryCTBookPage();
    LibraryCTBasePage libraryCTBasePage = new LibraryCTBasePage();
    LibraryCTBorrowingBooks borrowingBooks=new LibraryCTBorrowingBooks();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    Actions actions = new Actions(Driver.getDriver());
    LibraryCTBorrowingBooks libraryCTBorrowingBooks = new LibraryCTBorrowingBooks();


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

    //Fatih's story
    @Given("student is on homePage")
    public void student_is_on_home_page() {
        libraryCTLoginPage.login(ConfigurationReader.getProperty("usernameSt"),ConfigurationReader.getProperty("passwordSt"));
    }
    @When("student search for the books in the list below")
    public void student_search_for_the_books_in_the_list_below() {
    }
    @When("student finds the book which is avaliable")
    public WebElement student_finds_the_book_which_is_avaliable() throws InterruptedException {
    WebElement borrowbookbtn=null;
    while (borrowbookbtn==null) {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("(//tr[@role=\"row\"]//td[7])"));
        int pagenum=Integer.parseInt(Driver.getDriver().findElement(By.xpath("//li[@class=\"page-item active\"]")).getText());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals("")) {
                borrowbookbtn = Driver.getDriver().findElement(By.xpath("(//tr[@role=\"row\"]//td[1])" + "[" +( i + 1) + "]"));
                break;
            }
        }
        if (borrowbookbtn==null) {
            WebElement page = Driver.getDriver().findElement(By.xpath("//li[@class=\"page-item active\"]//following-sibling::li"));
            actions.moveToElement(page).click(page).perform();
            pagenum++;
            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//li[@class=\"page-item active\"]//a[.='" + pagenum + "']"))));
        }
    }
    return borrowbookbtn;
    }
    @Then("student clicks Borrow Book button")
    public void student_clicks_borrow_book_button() throws InterruptedException {
    student_finds_the_book_which_is_avaliable().click();
    }
    @Then("student should be able to borrow")
    public void student_should_be_able_to_borrow() {
        Assert.assertTrue(libraryCTBorrowingBooks.bookBrwdMsg.isDisplayed());
    }
}
