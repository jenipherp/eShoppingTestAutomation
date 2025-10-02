package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testingexample.pages.BasePage;
import org.testingexample.pages.HomePage;
import org.testingexample.pages.LogOutPage;
import org.testingexample.pages.LoginPage;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{


    @Test(dependsOnMethods = "test.LoginTest.loginwithValidCredentials",groups = "smoke")
    public void logout(){
        //HomePage homePage = new HomePage(driver);
        LogOutPage logOutPage = new LogOutPage(driver);

        logOutPage.logout();
    }
}
