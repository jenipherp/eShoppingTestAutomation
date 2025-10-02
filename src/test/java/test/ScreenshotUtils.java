package test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testname){
        String screenshotPath = System.getProperty("user.dir")+"/test-output/screenshots/" + testname +".png";
        try{
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(Paths.get(System.getProperty("user.dir")+"/test-output/screenshots/"));
            Files.copy(src.toPath(), Paths.get(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
