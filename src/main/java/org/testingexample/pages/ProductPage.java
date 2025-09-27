package org.testingexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By productCategory = By.xpath("//a[text()='Men']");
    private By productCard = By.cssSelector(".shopcategory-products .item a");
}
