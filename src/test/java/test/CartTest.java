package test;

import org.testingexample.pages.CartPage;
import org.testingexample.pages.HomePage;
import org.testingexample.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    private int beforeCount;

    @Test(groups = "smoke")
    public void addItem(){
        HomePage home = new HomePage(driver);
        home.open();

        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        beforeCount = cart.getCartBadgeCount();
        System.out.println(beforeCount);
        product.openMenCategory();
        product.addFirstProducttoCart();
        cart.addItemToCart();
    }
    @Test(dependsOnMethods = "addItem")
    public void removeItem(){
        CartPage cart = new CartPage(driver);
        cart.removeItemFromCart();
    }
    @Test(dependsOnMethods = "addItem")
    public void checkout(){
        CartPage cart = new CartPage(driver);
        cart.proceedCheckOut();
    }
    @Test(dependsOnMethods = "addItem")
    public void cartBadgeValidate(){
        CartPage cart = new CartPage(driver);
        int afterCount = cart.getCartBadgeCount();
        System.out.println(afterCount);
        Assert.assertEquals(afterCount, beforeCount+1);
    }
}
