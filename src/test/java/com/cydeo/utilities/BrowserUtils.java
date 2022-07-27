package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserUtils {

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String eachWindow : allWindowHandles) {
            //driver.switchTo().window(eachWindow) syntax will switch each window and driver will be able to see each window
            Driver.getDriver().switchTo().window(eachWindow);

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title verification failed", actualTitle.contains(expectedTitle));

    }

    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());

    }

    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForUrl(String url){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(url));
    }

    public static boolean ifButtonOnTheLeft(String buttonOne, String buttonTwo){
        boolean check = false;
        String xpath = "";
        xpath = "//a[@title='"+buttonOne+"']/..//preceding-sibling::a[@title='"+buttonTwo+"']";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        if (element.isDisplayed()){
            check = true;
        }
        return check;
    }

    public static void waitForClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void moveToElement(WebElement element){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).perform();
    }

}

