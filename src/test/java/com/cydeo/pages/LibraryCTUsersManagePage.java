package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryCTUsersManagePage {

    public LibraryCTUsersManagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    public WebElement addUser;

    @FindBy(name = "full_name")
    public WebElement fullNameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(id = "address")
    public WebElement addressInput;

    @FindBy(xpath = "//button[.='Save changes']")
    public WebElement saveChangesBtn;

    @FindBy(xpath = "//div[@class='toast toast-success']")
    public WebElement userCreatedSign;



}
