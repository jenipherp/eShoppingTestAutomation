package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testingexample.pages.HomePage;
import org.testingexample.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Objects;

public class LoginTest extends BaseTest {

    @Test(groups = "smoke")
    public void loginwithValidCredentials() {
        HomePage home = new HomePage(driver);
        home.open();
        home.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@gmail.com", "test123");
        loginPage.clickLogin();

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/login"));
    }

    @Test(groups = "regression")
    public void loginwithInvalidPassword() throws AWTException {
        HomePage home = new HomePage(driver);
        home.open();
        home.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@gmail.com", "test");
        loginPage.clickLogin();

        //with invalid password alert msg box opens and click ok in the alert box
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
        // driver.switchTo().window(driver.getWindowHandle());
        //Thread.sleep(500);
        //Alert alert = driver.switchTo().alert();
        alert.accept();
        // Thread.sleep(500);

        //Fallback - press enter key - not working for alert.accept()
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }
    @Test(groups = "regression")
    public void loginwithInvalidEmail() throws AWTException {
        HomePage home = new HomePage(driver);
        home.open();
        home.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalidemail@gmail.com", "test123");
        loginPage.clickLogin();

        //with invalid credential alert msg box opens and click ok in the alert box
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
      Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
      // driver.switchTo().window(driver.getWindowHandle());
       //Thread.sleep(500);
       //Alert alert = driver.switchTo().alert();
       alert.accept();
       // Thread.sleep(500);

        //Fallback - press enter key - not working for alert.accept()
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }
    @Test(groups = "regression")
    public void loginwithoutCredentials(){
        HomePage home = new HomePage(driver);
        home.open();
        home.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
       // loginPage.login("invalidemail@gmail.com", "test123");
        loginPage.clickLogin();
    }
}
