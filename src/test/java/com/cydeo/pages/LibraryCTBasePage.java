package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LibraryCTBasePage {

    public LibraryCTBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='menu_item']//a[@href='#dashboard']")
    public WebElement dashboardModuleBtn;

    @FindBy(xpath = "//ul[@id='menu_item']//a[@href='#users']")
    public WebElement usersModuleBtn;

    @FindBy(xpath = "//ul[@id='menu_item']//a[@href='#books']")
    public WebElement booksModuleBtn;

    @FindBy(xpath = "//ul[@id='menu_item']//a[@href='#borrowing-books']")
    public WebElement borrowingBooksModuleBtn;

    @FindBy(id = "navbarDropdown")
    public WebElement userDropdown;

    @FindBy(linkText = "Log Out")
    public WebElement logOutBtn;

    @FindBy(xpath = "//li[@class='nav-item']")
    public List<WebElement> models;



    public void logOut(){
        BrowserUtils.moveToElement(userDropdown);
        logOutBtn.click();
    }

}
