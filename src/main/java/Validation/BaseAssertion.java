package Validation;

import Uitils.ActionBot;
import Uitils.WaitBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public abstract class BaseAssertion {
    protected WebDriver driver;
    protected WaitBot waitBot;
    protected ActionBot actionBot;
    protected BaseAssertion(WebDriver driver){
        this.driver=driver;
        this.waitBot=new WaitBot(driver);
        this.actionBot=new ActionBot(driver);
    }
    protected abstract void assertTrue (boolean condition, String message);
    protected abstract void assertFalse (boolean condition, String message);
    protected abstract void assertEquals (String actual, String expected, String message);

    public void elementIsDisplayed(By locator){
      boolean flag =  waitBot.fluentWait().until(d->{
            try {
                d.findElement(locator).isDisplayed();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
        assertTrue(flag,"isn't visible");

    }
    public void assertUrl(String expectedUrl){
        String actualUrl= driver.getCurrentUrl();
        assertEquals(actualUrl,expectedUrl,"doesn't match url");
    }
    public void assertTitle (String expectedTitle){
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle,expectedTitle,"doesn't match title");
    }

}
