package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void SetUp() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        //launch browser
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
//
//        if(extent != null){
//            extent.flush();
//        }
//    }
}
