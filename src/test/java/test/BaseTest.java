package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.io.File;

public class BaseTest {

    protected static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser","profile"})
    public void SetUp(@Optional("firefox") String browserParam, @Optional("smoke") String profileParam) {
        //read from the command line
        String browser = System.getProperty("browser", browserParam);
        String profile = System.getProperty("profile", profileParam);

        //Extent report setup
        File reportsDir = new File(System.getProperty("GITHUB_WORKSPACE", ".") + "/reports");
        // Extent report setup
        File reportFile = new File(reportsDir, "extent-report.html");

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFile);
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        //setup for headless mode for chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");



        //launch browser
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://jeni-genii.onrender.com");
        //driver.get("http://localhost:3000/");
        System.out.println("Running "+profile+" test suite on "+browser);
    }


   @AfterSuite(alwaysRun = true)
   public void tearDown(){
       if(driver != null) {
           driver.quit();
       }

       if(extent != null){
           extent.flush();
       }
   }
}
