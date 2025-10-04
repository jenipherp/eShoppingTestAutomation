package org.testingexample.pages;

import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage extends BasePage{

    //ProductPage product = new ProductPage(driver);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By cartLink = By.cssSelector("a[href='/cart']");
    private By checkOutBtn = By.xpath("//button[text()='Proceed to Checkout']");
    private By cartBadge = By.cssSelector(".nav-cart-count");
    private By removeItem = By.cssSelector(".cartitems-remove-icon");

    public boolean addItemToCart(){
            //waitForVisibility(product.goToCart()) ;
        if(cartBadge!=null) click(cartLink);
        return true;
    }

    public void proceedCheckOut(){
        waitForClickable(checkOutBtn).click();
    }

    public void removeItemFromCart(){
            if(addItemToCart()){
                click(removeItem);
            }
    }

    public int getCartBadgeCount(){
        WebElement cartCount = waitForVisibility(cartBadge);
       return Integer.parseInt(cartCount.getText());
    }
}
