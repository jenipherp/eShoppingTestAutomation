package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage{

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    private By loginLink = By.xpath("//button[text()='Login']");
    private By signupLink = By.linkText("Signup");

    public void open(){
       driver.get("https://jeni-genii.onrender.com");
        //driver.get("http://localhost:3000/");
        waitForVisibility(loginLink);
    }

    public void goToLogin(){
        click(loginLink);
    }
    public void goToSignup(){
        WebElement signup = waitForVisibility(signupLink);
        signup.click();
    }
}
