package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class ProductDetailsTest {
    WebDriver driver;
    @Test
    public void verifyProductDetailsTC(){
        new ProductsPage(driver).clickOnViewProduct("Blue Top");
        new ProductDetailsPage(driver).verifyProductDetails("Blue Top","Rs. 500");
    }
    @Test
    public void verifyMessageReviewTC(){
        new ProductsPage(driver).clickOnViewProduct("Sleeveless Dress");
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.fillReview("Automation Tester","autotest2025@gmail.com","Fantastic Product");
        productDetailsPage.verifyReviewSubmit("Thank you for your review.");
    }
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.initiateDriver("chrome");
        driver.get("https://automationexercise.com/products");
    }
    @AfterMethod
    public void tearDown(){
        WebDriverFactory.closeDriver();
    }
}
