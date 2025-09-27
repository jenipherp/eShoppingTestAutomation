package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {

    public  WebDriver driver;

    @BeforeClass
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void landingPage(){
        driver.get("https://jeni-genii.onrender.com");
    }

//    @AfterClass
//    public void tearDown(){
//        if(driver != null) {
//            driver.quit();
//        }
//    }
}
