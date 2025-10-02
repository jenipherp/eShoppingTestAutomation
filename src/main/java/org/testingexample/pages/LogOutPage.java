package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage extends BasePage{

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    private By logOutLink = By.xpath("//*[contains(text(),'Logout')]");

    public void logout(){
        waitForClickable(logOutLink).click();
    }
}
