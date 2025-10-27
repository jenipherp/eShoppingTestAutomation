package test;

import org.testingexample.pages.LogOutPage;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{


    // @Test(dependsOnMethods = "test.LoginTest.loginwithValidCredentials",groups = "smoke")
    @Test(dependsOnMethods = "test.ProductTest.testProduct",groups = "smoke")
    public void logout(){
        //HomePage homePage = new HomePage(driver);
        LogOutPage logOutPage = new LogOutPage(driver);

        logOutPage.logout();
    }
}
