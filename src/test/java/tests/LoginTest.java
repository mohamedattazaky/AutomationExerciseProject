package tests;

import PagesComponents.NavigationBar;
import dataReader.JsonReader;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupLoginPage;

public class LoginTest {
    WebDriver driver;
    JsonReader loginData;
    NavigationBar navigationBar;

    @BeforeClass
    public void preconditions() {
        loginData = new JsonReader("login-data");
    }

    @Test
    public void validLoginTC() {
        new SignupLoginPage(driver).enterLogin(loginData.getJsonData("valid_email"), loginData.getJsonData("valid_password"));
        new NavigationBar(driver).verifyUser(loginData.getJsonData("name"));
    }

    @Test
    public void loginWithInValidEmail() {
        SignupLoginPage login = new SignupLoginPage(driver);
        login.enterLogin(loginData.getJsonData("invalid_email"), loginData.getJsonData("valid_password"));
        login.verifyLoginError(loginData.getJsonData("error"));

    }

    @Test
    public void loginWithInValidPassword() {
        SignupLoginPage login = new SignupLoginPage(driver);
        login.enterLogin(loginData.getJsonData("valid_email"), loginData.getJsonData("invalid_password"));
        login.verifyLoginError(loginData.getJsonData("error"));

    }
    @Test
    public void loginWithFieldsEmpty(){
        SignupLoginPage login = new SignupLoginPage(driver);
        login.enterLogin("","");
        login.verifyErrorFieldsEmpty();
    }
    @Test
    public void verifyLogout(){
        new SignupLoginPage(driver).enterLogin(loginData.getJsonData("valid_email"), loginData.getJsonData("valid_password"));
        navigationBar = new NavigationBar(driver);
        navigationBar.verifyUser(loginData.getJsonData("name"));
        navigationBar.clickOnLogoutButton();
    }

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.initiateDriver("chrome");
        new NavigationBar(driver).navigate();
        driver.navigate().to("https://automationexercise.com/login");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.closeDriver();
    }

}