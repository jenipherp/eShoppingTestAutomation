package test;

import org.testingexample.pages.HomePage;
import org.testingexample.pages.ProductPage;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

    @Test(groups = "smoke")
    public void testProduct(){
        HomePage home = new HomePage(driver);
        home.open();

        ProductPage product = new ProductPage(driver);
        product.openMenCategory();
        product.openProduct();
    }
}
