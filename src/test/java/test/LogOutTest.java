package test;

import org.openqa.selenium.By;
import org.testingexample.pages.HomePage;
import org.testingexample.pages.LoginPage;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{

    //LoginTest logintest = new LoginTest();
    @Test(groups = "smoke", dependsOnMethods = {"test.LoginTest.loginwithValidCredentials"})
    public void logout(){
        //HomePage home = new HomePage(driver);

        //LoginPage loginpage = new LoginPage(driver);

        driver.findElement(By.xpath("//button[contains(text(),'Logout')]")).click();
    }
}
