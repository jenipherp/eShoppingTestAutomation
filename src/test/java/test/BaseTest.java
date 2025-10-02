package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://jeni-genii.onrender.com");
    }


//    @AfterSuite(alwaysRun = true)
//    public void tearDown(){
//        if(driver != null) {
//            driver.quit();
//        }
//    }
}
