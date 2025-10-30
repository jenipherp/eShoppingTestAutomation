package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage_NavigationBar extends BasePage {


    public HomePage_NavigationBar(WebDriver driver) {
        super(driver);
    }

    By logo = By.cssSelector(".nav-logo img");
    By menuShop = By.linkText("Shop");
    By menuMen = By.linkText("Men");
    By menuWomen = By.linkText("Women");
    By menuKids = By.linkText("Kids");
    By loginLink = By.xpath("//button[text()='Login']");
    By cartIcon = By.cssSelector("a[href='/cart']");

    public boolean isLogoDisplayed(){
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isMenuLinksDisplayed(String linkText){
        return driver.findElement(By.linkText(linkText)).isDisplayed();
    }

    public boolean isLoginDisplayed(){
        return driver.findElement(loginLink).isDisplayed();
    }

    public boolean isCartIconDisplayed(){
        return driver.findElement(cartIcon).isDisplayed();
    }
}
