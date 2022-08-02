package com.cydeo.step_def;

import com.cydeo.pages.LibraryCTBookPage;
import com.cydeo.pages.LibraryCTLoginPage;
import com.cydeo.pages.borrowBookPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class borrowBook {
   borrowBookPage homePage=new borrowBookPage();
   LibraryCTLoginPage libraryCTLoginPage= new LibraryCTLoginPage();
   LibraryCTBookPage bookPage=new LibraryCTBookPage();

    @Given("student is on homePage")
    public void student_is_on_home_page()
    {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        libraryCTLoginPage.login(ConfigurationReader.getProperty("usernameSt"), ConfigurationReader.getProperty("passwordSt"));
        String title=Driver.getDriver().getTitle();
        System.out.println("title");
    }
    @When("student clicks Borrow Book button of any available book")
    public void student_clicks_button_of_any_available_book() {
        bookPage.selectLengthOfRecords("100");
        for (int i = 1; i < 100; i++) {
            if (Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-primary btn-sm  ']")).isDisplayed()) {

                Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-primary btn-sm  ']")).click();
                break;
            }else{
                Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-angle-right']")).click();
            }

        }


    }

    @Then("student's name should be on the Borrowed By of selected book")
    public void student_s_name_should_be_on_the_of_selected_book() {
        String expectedText="Test Student 1";
        String actualText=homePage.borrowedByBox.getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Then("Borrow Book button should be disabled")
    public void borrow_book_button_should_be_disabled() {

        System.out.println("Borrow book button is enabled = " + homePage.borrowBookBox.isEnabled());
    }





}
