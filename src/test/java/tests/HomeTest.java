package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest {
    WebDriver driver;
    HomePage homePage;
    @Test
    public void chooseWomenCategory(){
        homePage = new HomePage(driver);
        homePage.chooseWomenCategory("Dress");
    }
    @Test
    public void chooseMenCategory(){
        homePage = new HomePage(driver);
        homePage.chooseMenCategory("Jeans");
    }
    @Test
    public void chooseKidsCategory(){
        homePage = new HomePage(driver);
        homePage.chooseKidsCategory("Dress");
    }
    @Test
    public void chooseBrand(){
        homePage = new HomePage(driver);
        homePage.chooseBrand("Polo");
    }
    @Test
    public void subscribeMail(){
        homePage = new HomePage(driver);
        homePage.subscribeMail("autotest@gmail.com");
    }
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.initiateDriver("chrome");
        driver.get("https://automationexercise.com");
    }
    @AfterMethod
    public void tearDown(){
        WebDriverFactory.closeDriver();
    }
}
