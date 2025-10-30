package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testingexample.pages.HomePage_Newsletter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewsletterTest extends BaseTest{


    @Test(priority = 1)
    public void verifyNewsletter(){
        HomePage_Newsletter newsletter = new HomePage_Newsletter(driver);
        Assert.assertTrue(newsletter.isNewsletterVisible(),"Newsletter section is not visible");
    }

    @Test(priority = 2)
    public void verifyNewsletterwithValidEmail(){
        HomePage_Newsletter newsletter = new HomePage_Newsletter(driver);
        newsletter.enterEmail("test@gmail.com");
        newsletter.clickSubscribeBtn();
    }

    @Test(priority = 3)
    public void VerifyNewsletterwithInvalidEmail(){
        HomePage_Newsletter newsletter = new HomePage_Newsletter(driver);
        newsletter.enterEmail("test#gmail.com");
        newsletter.clickSubscribeBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMsg = alert.getText();
        System.out.println(alertMsg);
        alert.accept();
    }
}
