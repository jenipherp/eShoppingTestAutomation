package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    //ProductPage product = new ProductPage(driver);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By cartLink = By.cssSelector("a[href='/cart']");
    private By checkOutBtn = By.xpath("//button[text()='Proceed to Checkout']");
    private By cartBadge = By.cssSelector(".nav-cart-count");

    public void productInCart(){
            //waitForVisibility(product.goToCart()) ;
        if(cartBadge!=null) click(cartLink);

    }

    public void proceedCheckOut(){
        waitForClickable(checkOutBtn).click();
    }
}
