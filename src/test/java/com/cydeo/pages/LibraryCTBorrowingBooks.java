package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryCTBorrowingBooks {

    @FindBy(xpath = "//td[.='NOT RETURNED ']")
    public WebElement unReturnedFirstBook;


    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement bookBrwdMsg;

    public String nameOfTheReturBook(WebElement book)
    {
        return book.findElement(By.xpath("//..//td[2]")).getText();
    }

    public void returnTheBook(WebElement book)
    {
        book.findElement(By.xpath("//..//td[1]")).click();
    }

    public LibraryCTBorrowingBooks(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
