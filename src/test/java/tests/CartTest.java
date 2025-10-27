package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class CartTest {
    WebDriver driver;
    @Test
    public void verifyProductDetailsOnCartTC(){
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnAddToCart("Blue Top");
        productsPage.verifyAddedToCart("Your product has been added to cart.");
        productsPage.clickOnViewCart();
        new CartPage(driver).verifyProductDetailsOnCart("Blue Top","Rs. 500","1","Rs. 500");
    }
    @Test
    public void verifyDeleteProductFromCart(){
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnAddToCart("Blue Top");
        productsPage.clickOnViewCart();
       CartPage cartPage = new CartPage(driver);
               cartPage.clickOnRemoveProduct("Blue Top");
        cartPage.verifyEmptyCart();
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
