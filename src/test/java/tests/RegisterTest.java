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
import pages.SignupPage;
import timeManager.TimeManage;

public class RegisterTest {
    WebDriver driver;
    JsonReader testData;
    SignupPage fullRegister;
    NavigationBar navigationBar;
    @BeforeClass
    public void preconditions(){
        testData = new JsonReader("register-data");

    }
    @Test
    public void validSignupTC(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
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
        fullRegister.clickCreateBtn();
        fullRegister.verifyAccountCreated();
        fullRegister.clickContinueBtn();
        navigationBar = new NavigationBar(driver);
        navigationBar.deleteAccount();
        navigationBar.verifyDeleteAccount("Your account has been permanently deleted!");
        navigationBar.clickOnContinueAfterDelete();
    }
    @Test
    public void verifyErrorMessageWhenAccountCreatedBefore(){
       SignupLoginPage Register = new SignupLoginPage(driver);
                Register.enterSignup(testData.getJsonData("name_exist"), testData.getJsonData("email_exist") );
                Register.verifySignupExist("Email Address already exist!");
    }
    @Test
    public void signupWithInvalidEmailFormat(){
        SignupLoginPage Register = new SignupLoginPage(driver);
        Register.enterSignup(testData.getJsonData("name"),"autotest.com");
        Register.verifySignupError();
    }
    @Test
    public void signupWithPasswordFieldEmpty(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
                testData.getJsonData("title_male"),
                "",
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
        fullRegister.clickCreateBtn();
        fullRegister.verifyError();
    }
    @Test
    public void signupWithFirstNameFieldEmpty(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
                testData.getJsonData("title_male"),
                testData.getJsonData("password"),
                testData.getJsonData("day"),
                testData.getJsonData("month"),
                testData.getJsonData("year"),
                "",
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
        fullRegister.clickCreateBtn();
        fullRegister.verifyError();
    }
    @Test
    public void signupWithLastNameFieldEmpty(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
                testData.getJsonData("title_male"),
                testData.getJsonData("password"),
                testData.getJsonData("day"),
                testData.getJsonData("month"),
                testData.getJsonData("year"),
                testData.getJsonData("first_name"),
                "",
                testData.getJsonData("company"),
                testData.getJsonData("address_one"),
                testData.getJsonData("address_two"),
                testData.getJsonData("country"),
                testData.getJsonData("state"),
                testData.getJsonData("city"),
                testData.getJsonData("zipcode"),
                testData.getJsonData("mobile_number")
        );
        fullRegister.clickCreateBtn();
        fullRegister.verifyError();
    }
    @Test
    public void signupWithAddressFieldEmpty(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
                testData.getJsonData("title_male"),
                testData.getJsonData("password"),
                testData.getJsonData("day"),
                testData.getJsonData("month"),
                testData.getJsonData("year"),
                testData.getJsonData("first_name"),
                testData.getJsonData("last_name"),
                testData.getJsonData("company"),
                "",
                testData.getJsonData("address_two"),
                testData.getJsonData("country"),
                testData.getJsonData("state"),
                testData.getJsonData("city"),
                testData.getJsonData("zipcode"),
                testData.getJsonData("mobile_number")
        );
        fullRegister.clickCreateBtn();
        fullRegister.verifyError();
    }
    @Test
    public void signupWithStateFieldEmpty(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
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
                "",
                testData.getJsonData("city"),
                testData.getJsonData("zipcode"),
                testData.getJsonData("mobile_number")
        );
        fullRegister.clickCreateBtn();
        fullRegister.verifyError();
    }
    @Test
    public void signupWithCityFieldEmpty(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
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
                "",
                testData.getJsonData("zipcode"),
                testData.getJsonData("mobile_number")
        );
        fullRegister.clickCreateBtn();
        fullRegister.verifyError();
    }
    @Test
    public void signupWithZipFieldEmpty(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
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
                "",
                testData.getJsonData("mobile_number")
        );
        fullRegister.clickCreateBtn();
        fullRegister.verifyError();
    }
    @Test
    public void signupWithMobileNumberFieldEmpty(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
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
                ""
        );
        fullRegister.clickCreateBtn();
        fullRegister.verifyError();
    }
    @Test
    public void verifyMobileNumberFieldAcceptsNumbersOnly(){
        new SignupLoginPage(driver).enterSignup(testData.getJsonData("name"), testData.getJsonData("email")+ TimeManage.simpleTimeStamp()+"@gmail.com");
        fullRegister = new SignupPage(driver);
        fullRegister.fillSignup(
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
                "01123456789MS"
        );
        fullRegister.clickCreateBtn();
        fullRegister.verifyError();
    }
    @BeforeMethod
    public void setup(){
     driver= WebDriverFactory.initiateDriver("chrome");
    // new NavigationBar(driver).navigate();
     driver.get("https://automationexercise.com/login");
    }
    @AfterMethod
    public void tearDown(){
       WebDriverFactory.closeDriver();
    }
}
