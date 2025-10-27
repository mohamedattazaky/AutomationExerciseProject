package media;

import logs.LogsManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import timeManager.TimeManage;

import java.io.File;

public class GetScreenshot {
    public static final String SCREENPATH = "test-outputs/ScreenShot/";

    public static void getScreen(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dsc = new File(SCREENPATH + screenshotName + "_" + TimeManage.getTimeStamp() + ".png");
            FileUtils.copyFile(src, dsc);
            LogsManager.info("Captured screenshot");
        } catch (Exception e) {
            LogsManager.error("Failed to capture screenshot");

        }
    }
}
