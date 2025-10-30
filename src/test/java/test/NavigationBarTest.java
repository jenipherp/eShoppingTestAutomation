package test;

import org.testingexample.pages.HomePage_NavigationBar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBarTest extends BaseTest{

    @Test
    public void verifyNavigationBarElements(){
        HomePage_NavigationBar navigation = new HomePage_NavigationBar(driver);

        Assert.assertTrue(navigation.isLogoDisplayed(),"Logo not visible");
        Assert.assertTrue(navigation.isMenuLinksDisplayed("Shop"),"Shop link not visible");
        Assert.assertTrue(navigation.isMenuLinksDisplayed("Men"),"Men link not visible");
        Assert.assertTrue(navigation.isMenuLinksDisplayed("Women"),"Women link not visible");
        Assert.assertTrue(navigation.isMenuLinksDisplayed("Kids"),"Kids link not visible");
        Assert.assertTrue(navigation.isLoginDisplayed(),"Login button not visible");
        Assert.assertTrue(navigation.isCartIconDisplayed(),"Cart icon not visible");

    }
}
