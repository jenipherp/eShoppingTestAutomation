package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testingexample.pages.HomePage;
import org.testingexample.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class SignUpTest extends BaseTest{

    @Test
    public void testSignup(){
        HomePage home = new HomePage(driver);
        home.open();
        home.goToLogin();
        home.goToSignup();

        SignUpPage signup = new SignUpPage(driver);
        signup.enterUserName("testuser");
        signup.enterEmail("testuser@gmail.com");
        signup.enterPassword("test123");
        signup.clickCheckbox();
        signup.clickSignup();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/Signup"));
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/Signup"));
    }
}
