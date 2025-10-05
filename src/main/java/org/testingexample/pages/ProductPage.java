package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By productCategory = By.xpath("//a[text()='Men']");
    private By productCard = By.cssSelector(".shopcategory-products .item a");
    private By productTitle = By.cssSelector(".shopcategory-products .item p");
    private By addtoCartBtn = By.cssSelector(".productdisplay-right-button");
    private By cartLink = By.cssSelector("a[href='/cart']");

    public void openMenCategory(){
        waitForPresence(productCategory).click();
    }

    public void addFirstProducttoCart(){
        waitForVisibility(productCard);
        List<WebElement> cards = driver.findElements(productCard);
        WebElement addBtn = cards.get(0);
        addBtn.click();
        WebElement addtoCartWait = waitForClickable(addtoCartBtn);
        addtoCartWait.click();
        System.out.println(driver.findElement(By.cssSelector(".nav-cart-count")).getText());
    }

    public void addProductByIndex(int index, int quantity){
        waitForVisibility(productCard);
        List<WebElement> cards = driver.findElements(productCard);
        if(index<=cards.size()){
            WebElement card = cards.get(index);
            card.click();
            for(int i =0;i<quantity;i++) {
                WebElement addtocartBtn = waitForClickable(addtoCartBtn);
                addtocartBtn.click();
            }
        }
    }

    public void addProductByName(String name){
        waitForVisibility(productCard);
        List<WebElement> cards = driver.findElements(productCard);
        for(WebElement card:cards){
            String title = card.findElement(productTitle).getText();
            if(title.toLowerCase().contains(name.toLowerCase())){
                //card.click();
                WebElement addtocartBtn = waitForClickable(addtoCartBtn);
                addtocartBtn.click();
               // wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
                return;
            }
        }
    }

    public void addMultipleProductbyIndexes( int quantity,int... indexes){
        for(int index:indexes){
            addProductByIndex(index, quantity);
        }
    }

    public void addMultipleProductbyName(String... names){
        for (String name:names){
            addProductByName(name);
        }
    }

    public void goToCart(){
        click(cartLink);
    }
}
