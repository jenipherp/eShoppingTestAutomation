package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By productCategory = By.xpath("//a[text()='Men']");
    private By productCard = By.cssSelector(".shopcategory-products .item a");
    private By productTitle = By.xpath("//h1[@class='productdisplay-right']");
    private By addtoCartBtn = By.cssSelector(".productdisplay-right-button");
    private By cartLink = By.cssSelector("a[href='/cart']");

    public void openMenCategory(){
        waitForPresence(productCategory).click();
    }

    public void openProduct(){
        waitForVisibility(productCard);
        List<WebElement> cards = driver.findElements(productCard);
        WebElement addBtn = cards.get(0);
        addBtn.click();
        WebElement addtoCartWait = waitForClickable(addtoCartBtn);
        addtoCartWait.click();
        System.out.println(driver.findElement(By.cssSelector(".nav-cart-count")).getText());
    }

    public void goToCart(){
        click(cartLink);
    }
}
