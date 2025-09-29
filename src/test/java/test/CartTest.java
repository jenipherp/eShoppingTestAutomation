package test;

import org.testingexample.pages.CartPage;
import org.testingexample.pages.HomePage;
import org.testingexample.pages.ProductPage;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test(groups = "smoke")
    public void checkout(){
        HomePage home = new HomePage(driver);
        home.open();

        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        product.openMenCategory();
        product.openProduct();
        //product.goToCart();
        cart.addItemToCart();
        cart.proceedCheckOut();

    }
}
