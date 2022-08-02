package com.cydeo.step_def;

import com.cydeo.pages.LibraryCTBasePage;
import com.cydeo.pages.LibraryCTLoginPage;
import com.cydeo.pages.LibraryCTUsersManagePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class B26G16_67Steps {
    LibraryCTLoginPage loginPage = new LibraryCTLoginPage();
    LibraryCTBasePage basePage = new LibraryCTBasePage();

    LibraryCTUsersManagePage managePage = new LibraryCTUsersManagePage();

    Faker faker = new Faker();

    @Given("librarian is on the homePage")
    public void librarian_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.login(ConfigurationReader.getProperty("usernameLi"),ConfigurationReader.getProperty("passwordLi"));
    }
    @When("librarian click users module")
    public void librarian_click_users_module() {
        basePage.usersModuleBtn.click();
    }
    @When("librarian click add user button")
    public void librarian_click_add_user_button() {
        managePage.addUser.click();
    }
    @When("librarian enter full name, password, email and address")
    public void librarian_enter_full_name_password_email_and_address() {
        managePage.fullNameInput.sendKeys(faker.funnyName().name());
        managePage.passwordInput.sendKeys(faker.letterify("********"));
        managePage.emailInput.sendKeys(faker.internet().emailAddress());
        managePage.addressInput.sendKeys(faker.address().fullAddress());
    }
    @When("librarian click save changes")
    public void librarian_click_save_changes() {
        managePage.saveChangesBtn.click();
    }
    @Then("verify a new user is created")
    public void verify_a_new_user_is_created() {
        Assert.assertTrue(managePage.userCreatedSign.isDisplayed());
    }

}
