package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailId = By.name("email");
    private By pass = By.name("password");
    private By loginPath = By.xpath("//button[contains(text(),'Submit ')]");
    private By logoutButton = By.xpath("//button[text()='Logout']");
    public void enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailId)).sendKeys(email);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pass)).sendKeys(password);
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginPath)).click();
        waitForVisibility(logoutButton);

    }
}
