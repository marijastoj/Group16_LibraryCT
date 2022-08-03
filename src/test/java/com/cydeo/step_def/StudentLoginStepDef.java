package com.cydeo.step_def;

import com.cydeo.pages.LibraryCTBasePage;
import com.cydeo.pages.LibraryCTLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StudentLoginStepDef {

    LibraryCTLoginPage libraryCTLoginPage = new LibraryCTLoginPage();
    LibraryCTBasePage libraryCTBasePage = new LibraryCTBasePage();

    @Given("student is on the loginPage")
    public void student_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }
    @Then("verify that the URL is {string}")
    public void verify_that_the_url_is(String string) {
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://library2.cydeo.com/login.html";

        Assert.assertEquals(expectedURL,actualURL);
    }
    @When("student enters valid email address and password")
    public void student_enters_valid_email_address_and_password() {

       String loginEmail = ConfigurationReader.getProperty("usernameSt");
       String loginPass = ConfigurationReader.getProperty("passwordSt");

       libraryCTLoginPage.loginEmail.sendKeys(loginEmail);
       libraryCTLoginPage.loginPass.sendKeys(loginPass);

    }
    @When("student click sign in button")
    public void student_click_sign_in_button() {
        libraryCTLoginPage.signInBtn.click();

    }
    @Then("verify that there are {int} models on the page")
    public void verify_that_there_are_models_on_the_page(Integer int1) {
        Assert.assertEquals(int1+"", libraryCTBasePage.models.size()+"");
    }

}
