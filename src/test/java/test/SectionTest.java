package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testingexample.pages.HomePage_Sections;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SectionTest extends BaseTest{



    @Test(priority = 1)
    public void verifyLatestCollection(){
        HomePage_Sections sections = new HomePage_Sections(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(sections.isLatestCollectionVisible(),"Latest Collection section is not visible");
        sections.clickLatestColletion();

        wait.until(ExpectedConditions.urlContains("#newColl"));

        Assert.assertTrue(driver.getCurrentUrl().contains("#newColl"),"Latest collection did not navigate properly");
        driver.navigate().back();
    }

    @Test(priority = 2)
    public void verifyPopularinWomen(){
        HomePage_Sections sections = new HomePage_Sections(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(sections.isPopularinWomenVisible(),"Popular in women is not visible");
        sections.clickPopularinWomen();
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void verifyExclusiveOffer(){
        HomePage_Sections sections = new HomePage_Sections(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(sections.isexclusoveofferVisible(),"Exclusive offer section not visible");
        sections.clickExclusiveOffer();
        wait.until(ExpectedConditions.urlContains("/women"));
        Assert.assertTrue(driver.getCurrentUrl().contains("women"),"Exclusive offer page didnt navigate properly");
        driver.navigate().back();
    }

    @Test(priority = 4)
    public void verifyNewCollection(){
        HomePage_Sections sections = new HomePage_Sections(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(sections.isNewCollectionVisible(),"New collection section is not visible");
        sections.clickNewCollection();
        System.out.println("validated working fine");
        driver.navigate().back();
    }
}
