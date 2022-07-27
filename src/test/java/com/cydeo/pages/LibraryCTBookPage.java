package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LibraryCTBookPage extends LibraryCTBasePage{

    public LibraryCTBookPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "book_categories")
    public WebElement bookCategoriesDropdown;

    @FindBy(name = "tbl_books_length")
    public WebElement lengthOfRecordsDropdown;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//a[contains(@class,'add_book_btn')]")
    public WebElement addBookBtn;

    //@FindBy(xpath = "//label[.='Book Name']//following-sibling::input") -< just in case
    @FindBy(xpath = "//input[@name='name']")
    public WebElement bookNameBox;

    @FindBy(xpath = "//input[@name='isbn']")
    public WebElement isbnBox;

    @FindBy(xpath = "//input[@name='year']")
    public WebElement yearBox;

    @FindBy(xpath = "//input[@name='author']")
    public WebElement authorBox;

    @FindBy(id = "description")
    public WebElement descriptionBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChangesBtn;

    @FindBy(xpath = "//button[@type='cancel']")
    public WebElement cancelBtn;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement bookCreatedMessage;

    public void selectBookCategory(String genre){
        Select drop = new Select(bookCategoriesDropdown);
        drop.selectByVisibleText(genre);
    }

    //5, 10, 15, 50, 100, 200, 500
    public void selectLengthOfRecords(String value){
        Select drop = new Select(bookCategoriesDropdown);
        drop.selectByValue(value);
    }

}
