package Validation;

import logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

public class Validation extends  BaseAssertion{
    private static boolean used = false;
    static SoftAssert softAssert = new SoftAssert();
    public Validation(WebDriver driver){
        super(driver);
    }
    @Override
    public void assertTrue (boolean condition, String message){
        used = true ;
        softAssert.assertTrue(condition, message);

    }
    public void assertFalse (boolean condition, String message){
        used = true;
        softAssert.assertFalse(condition, message);
    }
    public void assertEquals (String actual, String expected, String message){
        used = true;
        softAssert.assertEquals(actual,expected,message);
    }
    public static void assertAll (ITestResult result){
        if(!used) return;
        try{
            softAssert.assertAll();
        } catch (AssertionError e) {
            LogsManager.error("Assertion Error" + e.getMessage());
            result.setStatus(ITestResult.FAILURE);
            result.setThrowable(e);
        }
        finally {
            softAssert = new SoftAssert();
        }
    }

}
