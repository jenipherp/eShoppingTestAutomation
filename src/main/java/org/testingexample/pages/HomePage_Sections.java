package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage_Sections extends BasePage{
    private WebDriverWait wait;

    public HomePage_Sections(WebDriver driver) {
        super(driver);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By latestCollection = By.cssSelector("a[href='#newColl']");
    By popularinWomen = By.cssSelector(".popular h1");
    By popularProduct = By.cssSelector(".popular .popular-item .item:nth-of-type(3)");
    By exclusiveOffer = By.cssSelector(".offers-left h1");
    By exclusiveChecknow = By.xpath("//button[text()='Check now']");
    By newCollection = By.cssSelector(".newcollections h1");
    By newCollectionItem = By.cssSelector(".newcollections .collections .item:nth-of-type(2)");

    public boolean isLatestCollectionVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(latestCollection)).isDisplayed();
    }

    public void clickLatestColletion(){
        wait.until(ExpectedConditions.elementToBeClickable(latestCollection)).click();
    }

    public boolean isPopularinWomenVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(popularinWomen)).isDisplayed();
    }

    public void clickPopularinWomen(){
        wait.until(ExpectedConditions.elementToBeClickable(popularProduct)).click();
    }

    public boolean isexclusoveofferVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(exclusiveOffer)).isDisplayed();

    }

    public void clickExclusiveOffer(){
        wait.until((ExpectedConditions.elementToBeClickable(exclusiveChecknow))).click();
    }

    public boolean isNewCollectionVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newCollection)).isDisplayed();
    }

    public void clickNewCollection(){
        wait.until(ExpectedConditions.elementToBeClickable(newCollectionItem)).click();
    }
}
