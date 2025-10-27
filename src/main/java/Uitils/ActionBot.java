package Uitils;

import logs.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionBot {
    private WebDriver driver;
    private WaitBot waitBot;

    public ActionBot(WebDriver driver) {
        this.driver = driver;
        this.waitBot = new WaitBot(driver);
    }

    public void click(By locator) {
        waitBot.fluentWait().until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                scrollToElement(locator);
                element.click();
                return true; // لو اتعمل كليك بيرجع true
            } catch (Exception e) {
                return false; // لو في Exception هيجرب تاني
            }
        });
    }
    public void sendKeys(By locator, String text) {
        waitBot.fluentWait().until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                new Actions(driver).scrollToElement(element).perform();
                element.clear();
                element.sendKeys(text);
                return true; // لو اتعمل كليك بيرجع true
            } catch (Exception e) {
                return false; // لو في Exception هيجرب تاني
            }
        });
    }


    public String getText(By locator) {
        return waitBot.fluentWait().until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                new Actions(driver).scrollToElement(element).perform();
                String msg = element.getText();
                return !msg.isEmpty() ? msg : null; // لو فاضي يرجع null عشان يعيد المحاولة
            } catch (Exception e) {
                return null; // يحصل Exception → هيجرب تاني
            }
        });
    }
    public void selectFromDropDown(By locator, String text){
        waitBot.fluentWait().until(d->{
            try{
                WebElement element = d.findElement(locator);
                new Actions(d).scrollToElement(element).perform();
                new Select(element).selectByVisibleText(text);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void hover(By locator){
        waitBot.fluentWait().until(d->{
            try {
                WebElement element = d.findElement(locator);
                scrollToElement(locator);
                new Actions(d).moveToElement(element).perform();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
    public String getValue(By locator) {
        return waitBot.fluentWait().until(driver -> {
            try {
                WebElement element = driver.findElement(locator);
                scrollToElement(locator);
                return element.getAttribute("value");
            } catch (Exception e) {
                return null; // لو في Exception يرجّع null علشان الwait يجرب تاني
            }
        });
    }

}