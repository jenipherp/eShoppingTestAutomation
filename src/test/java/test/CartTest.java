package test;

import org.testingexample.pages.CartPage;
import org.testingexample.pages.HomePage;
import org.testingexample.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    private int beforeCount;
    private String expectedProductname = "Men Green Solid Zippered Full-Zip Slim Fit Bomber Jacket";
    private String expectedPrice = "$85";
    private String expectedQuantity = "3";
    private String expectedTotal = "255";

    @Test(groups = "smoke")
    public void addItem(){
        HomePage home = new HomePage(driver);
        home.open();

        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        beforeCount = cart.getCartBadgeCount();
        System.out.println(beforeCount);
        product.openMenCategory();
        product.addProductByIndex(0,3);
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
    @Test(dependsOnMethods = "addItem")
    public void cartPage(){
        CartPage cart = new CartPage(driver);
        String actualPname = cart.getProductname();
        String actualPPrice =cart.getPrice();
        String actualPQuantity = cart.getQuantity();
        String actualPTotal = cart.getTotal();

        Assert.assertEquals(actualPname,expectedProductname);
        Assert.assertEquals(actualPPrice,expectedPrice);
        Assert.assertEquals(actualPQuantity,expectedQuantity);
        Assert.assertEquals(actualPTotal,expectedTotal);

    }
}
