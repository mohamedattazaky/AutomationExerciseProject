package tests;

import PagesComponents.NavigationBar;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationBarTest {
    WebDriver driver;
    NavigationBar navigationBar;

    @Test
    public void verifyTestCasesPageLoadsSuccessfully(){
        navigationBar = new NavigationBar(driver);
        navigationBar.clickOnTestCasesButton();
    }
    @Test
    public void verifyVideoTutorialsPageLoadsSuccessfully(){
        navigationBar = new NavigationBar(driver);
        navigationBar.clickOnVideoButton();
    }
    @Test
    public void verifyContactUsPageLoadsSuccessfully(){
        navigationBar = new NavigationBar(driver);
        navigationBar.clickOnContactButton();
    }
    @Test
    public void verifyApiTestingPageLoadsSuccessfully(){
        navigationBar = new NavigationBar(driver);
        navigationBar.clickOnApiTestingButton();
    }

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.initiateDriver("chrome");
        new NavigationBar(driver).navigate();
    }
    @AfterMethod
    public void tearDown(){
        WebDriverFactory.closeDriver();
    }
}
