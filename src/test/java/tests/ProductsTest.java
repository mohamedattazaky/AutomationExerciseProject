package tests;

import PagesComponents.NavigationBar;
import Uitils.ActionBot;
import drivers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;

import java.time.Duration;

public class ProductsTest {
    WebDriver driver;
    ProductsPage productsPage;
    ActionBot actionBot;
    @Test
    public void searchForProduct(){
        productsPage = new ProductsPage(driver);
        productsPage.searchProduct("Blue Top");
        productsPage.verifySearchProduct("Blue Top");
    }
    @Test
    public void addProductToCart(){
        productsPage = new ProductsPage(driver);
        productsPage.clickOnAddToCart("Blue Top");
        productsPage.verifyAddedToCart("Your product has been added to cart.");
    }
    @Test
    public void verifyQuantity(){
        productsPage = new ProductsPage(driver);
        productsPage.clickOnViewProduct("Blue Top");
        productsPage.verifyQuantity("2","Blue Top");
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




