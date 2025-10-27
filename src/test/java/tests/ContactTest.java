package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;

public class ContactTest {
    WebDriver driver;
    ContactPage contactPage;
    @Test
    public void fillContact(){
        contactPage = new ContactPage(driver);
        String filePath = System.getProperty("user.dir") + "/src/test/resources/2_1MVQ.jpg";
        System.out.println(filePath);
        contactPage.fillFormContact("AutoTest",
                "autotest@gmail.com",
                "Brands Polo",
                "I have a problem in size",
                filePath);
    }
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.initiateDriver("chrome");
        driver.get("https://automationexercise.com/contact_us");
    }
    @AfterMethod
    public void tearDown(){
        WebDriverFactory.closeDriver();
    }
}
