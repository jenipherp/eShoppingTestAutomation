package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testingexample.pages.HomePage;
import org.testingexample.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        HomePage home = new HomePage(driver);
        home.open();
        home.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@gmail.com", "test123");


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/Login"));
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/Login"));
    }

}
