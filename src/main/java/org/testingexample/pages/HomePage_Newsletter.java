package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage_Newsletter extends BasePage{

    private WebDriverWait wait;

    public HomePage_Newsletter(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By newsLetterSection = By.cssSelector(".newsletter h1");
    By email_Id = By.cssSelector("input[type='email']");
    By subscribeBTN = By.xpath("//button[contains(text(),'Subscribe')]");

    public boolean isNewsletterVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newsLetterSection)).isDisplayed();
    }

    public void enterEmail(String emailId){
        wait.until(ExpectedConditions.visibilityOfElementLocated(email_Id)).sendKeys(emailId);
    }

    public void clickSubscribeBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(subscribeBTN)).click();
    }
}
