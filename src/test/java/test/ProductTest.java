package test;

import org.testingexample.pages.LandingPage;
import org.testingexample.pages.ProductPage;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test(dependsOnMethods = "test.LoginTest.loginwithValidCredentials", groups = {"smoke"})
    public void testProduct() throws InterruptedException {

        ProductPage product = new ProductPage(driver);
        product.openMenCategory();
        product.addFirstProducttoCart();
       // product.addProductByIndex(5, 3);
        //product.addProductByName("Men Green Solid Zippered Full-Zip Slim Fit Bomber Jacket");
        //product.addMultipleProductbyIndexes(1,3,5);
    }

    public void cartBadge() {
    }

    @Test
    public void testProductStandAlone() throws InterruptedException {
        LandingPage home = new LandingPage(driver);
        home.open();
        testProduct();
    }

}
