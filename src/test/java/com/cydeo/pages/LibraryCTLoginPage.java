package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryCTLoginPage {

    public LibraryCTLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement loginEmail;

    @FindBy(id = "inputPassword")
    public WebElement loginPass;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInBtn;

    public void login(String username, String password){
        Driver.getDriver().get("https://library2.cydeo.com/login.html");
        loginEmail.sendKeys(username);
        loginPass.sendKeys(password);
        signInBtn.click();
    }
@FindBy(xpath="//div[@class = 'alert alert-danger']")
public WebElement alertMsg;
}
