package org.testingexample.pages;

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
    private By productname = By.cssSelector(".cartitems-format.cartitems-format-main p:first-of-type");
    private By price = By.cssSelector(".cartitems-format.cartitems-format-main p:nth-of-type(2)");
    private By quantity = By.cssSelector(".cartitems-quantity");
    private By total = By.cssSelector(".cartitems-format.cartitems-format-main p:nth-of-type(3)");

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

    //validate cart page
    public String getProductname(){
        String product = waitForVisibility(productname).getText();
        System.out.println(product);
        return product;
    }
    public String getPrice(){
        String productPrice = waitForVisibility(price).getText();
        System.out.println(productPrice);
        return productPrice;
    }

    public String getQuantity(){
        String quantityCount = waitForVisibility(quantity).getText();
        System.out.println(quantityCount);
        return quantityCount;
    }

    public String getTotal(){
        String totalValidate = waitForVisibility(total).getText();
        System.out.println(totalValidate);
        return totalValidate;
    }
}
