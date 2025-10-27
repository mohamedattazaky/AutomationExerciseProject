package tests;

import PagesComponents.NavigationBar;
import dataReader.JsonReader;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import timeManager.TimeManage;

public class PaymentTest {
    WebDriver driver;
    JsonReader testData;
    SignupPage register;
    ProductsPage productsPage;
    String timeStamp = TimeManage.simpleTimeStamp();
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    NavigationBar navigationBar;
    @Test
    public void registerNewAccount(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ timeStamp +"@gmail.com");
        register = new SignupPage(driver);
        register.fillSignup(
                testData.getJsonData("title_male"),
                testData.getJsonData("password"),
                testData.getJsonData("day"),
                testData.getJsonData("month"),
                testData.getJsonData("year"),
                testData.getJsonData("first_name"),
                testData.getJsonData("last_name"),
                testData.getJsonData("company"),
                testData.getJsonData("address_one"),
                testData.getJsonData("address_two"),
                testData.getJsonData("country"),
                testData.getJsonData("state"),
                testData.getJsonData("city"),
                testData.getJsonData("zipcode"),
                testData.getJsonData("mobile_number")
        );
        register.clickCreateBtn();
        register.verifyAccountCreated();
    }
    @Test (dependsOnMethods = "registerNewAccount")
    public void addProductToCart(){
        driver.navigate().to("https://automationexercise.com/products");
        productsPage = new ProductsPage(driver);
        productsPage.clickOnAddToCart("Blue Top");
        productsPage.verifyAddedToCart("Your product has been added to cart.");
        productsPage.clickOnViewCart();
        productsPage.clickOnProceedToCheckOut();
    }
    @Test (dependsOnMethods = {"addProductToCart","registerNewAccount"})
    public void checkOut(){
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.verifyDeliveryAddress(testData.getJsonData("title_male"),
                testData.getJsonData("first_name"),
                testData.getJsonData("last_name"),
                testData.getJsonData("company"),
                testData.getJsonData("address_one"),
                testData.getJsonData("address_two"),
                testData.getJsonData("city"),
                testData.getJsonData("state"),
                testData.getJsonData("zipcode"),
                testData.getJsonData("country"),
                testData.getJsonData("mobile_number")
        );

        checkoutPage.verifyBillingAddress(testData.getJsonData("title_male"),
                testData.getJsonData("first_name"),
                testData.getJsonData("last_name"),
                testData.getJsonData("company"),
                testData.getJsonData("address_one"),
                testData.getJsonData("address_two"),
                testData.getJsonData("city"),
                testData.getJsonData("state"),
                testData.getJsonData("zipcode"),
                testData.getJsonData("country"),
                testData.getJsonData("mobile_number")
        );
        checkoutPage.clickOnPlaceOrderButton();

    }
    @Test (dependsOnMethods = {"checkOut","addProductToCart","registerNewAccount"})
    public void payment(){
        paymentPage = new PaymentPage(driver);
        paymentPage.fillPayment(testData.getJsonData("card_name"),testData.getJsonData("card_number"),testData.getJsonData("cvc"),testData.getJsonData("card_month"), testData.getJsonData("card_year") );
        paymentPage.verifyPayment(testData.getJsonData("payment_message"));
    }
    @Test (dependsOnMethods = {"payment","checkOut","addProductToCart","registerNewAccount"})
    public void deleteAccount(){
        navigationBar = new NavigationBar(driver);
        navigationBar.deleteAccount();
        navigationBar.verifyDeleteAccount(testData.getJsonData("delete_message"));
        navigationBar.clickOnContinueAfterDelete();
    }

    @BeforeClass
    public void setup(){
        testData = new JsonReader("checkout-data");
        driver= WebDriverFactory.initiateDriver("chrome");
        new NavigationBar(driver).navigate();
        driver.navigate().to("https://automationexercise.com/login");
    }
    @AfterClass
    public void tearDown(){
        WebDriverFactory.closeDriver();
    }

}
