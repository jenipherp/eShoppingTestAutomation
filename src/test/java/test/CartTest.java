package test;

import org.testingexample.pages.CartPage;
import org.testingexample.pages.LandingPage;
import org.testingexample.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    private int beforeCount;
    private String expectedProductname = "Men Green Solid Zippered Full-Zip Slim Fit Bomber Jacket";
    private String expectedPrice = "$85";
    private String price = "85";
    private String expectedQuantity = "3";
    private int total = Integer.parseInt(price)*Integer.parseInt(expectedQuantity);
    private String expectedTotal = String.valueOf(total);

    @Test(dependsOnMethods = "test.LoginTest.loginwithValidCredentials", groups = {"smoke"})
    public void addItem(){
//        LandingPage home = new LandingPage(driver);
//        home.open();

        //ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        beforeCount = cart.getCartBadgeCount();
        System.out.println(beforeCount);
        //product.openMenCategory();
        //product.addProductByIndex(0,3);
        //cart.addItemToCart();
    }
//    @Test(dependsOnMethods = "addItem")
//    public void removeItem(){
//        CartPage cart = new CartPage(driver);
//        cart.removeItemFromCart();
//    }
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
        Assert.assertEquals(afterCount, 3);
    }
    @Test(dependsOnMethods = "addItem")
    public void cartPage(){
        CartPage cart = new CartPage(driver);
        String actualPname = cart.getProductname();
        String actualPPrice =cart.getPrice();
        String actualPQuantity = cart.getQuantity();
        String actualPTotal = cart.getTotal();
        System.out.println(expectedTotal);
        Assert.assertEquals(actualPname,expectedProductname);
        Assert.assertEquals(actualPPrice,expectedPrice);
        Assert.assertEquals(actualPQuantity,expectedQuantity);
        Assert.assertEquals(actualPTotal,expectedTotal);

    }
}
