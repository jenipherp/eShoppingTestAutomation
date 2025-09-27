package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private By name = By.name("username");
    private By emailId = By.name("email");
    private By pass = By.name("password");
    private By checkBox = By.cssSelector("input.loginsignup-fields-check[type='checkbox']");
    private By signup = By.xpath("//button[text()='Signup']");

    public void enterUserName(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(username);
    }

    public void enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailId)).sendKeys(email);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pass)).sendKeys(password);
    }

    public void clickCheckbox(){
        WebElement checkboxAvailable = wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        if(!checkboxAvailable.isSelected()){
            checkboxAvailable.click();
        }
    }

    public void clickSignup(){
        wait.until(ExpectedConditions.elementToBeClickable(signup)).click();
    }

    public void signup(String username, String email, String pass){
        enterUserName(username);
        enterEmail(email);
        enterPassword(pass);
        clickCheckbox();
        clickSignup();
    }
}