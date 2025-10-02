package test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = BaseTest.driver;

        String screenshotpath = ScreenshotUtils.captureScreenshot(driver,result.getMethod().getMethodName());
       // test.fail("Test Failed: "+ result.getMethod().getMethodName());
        test.fail("Test Failed"+result.getThrowable(),
                com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());

    }
}
