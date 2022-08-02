package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class borrowBookPage {
    public borrowBookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@onclick='Books.borrow_book(3591)']")
    public WebElement borrowBookBox;

    @FindBy(xpath = "(//td[.='1234'])[1]/following-sibling::td")
    public WebElement borrowedByBox;


}
