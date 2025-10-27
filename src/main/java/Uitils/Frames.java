package Uitils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frames {
    private WebDriver driver;
    private WaitBot waitBot;

    public Frames(WebDriver driver){
        this.driver=driver;
        this.waitBot=new WaitBot(driver);
    }

    public void frameindex (int index){
        waitBot.fluentWait().until(d->{
            try {
                d.switchTo().frame(index);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
    public void framename (String nameorid){
        waitBot.fluentWait().until(d->{
            try {
                d.switchTo().frame(nameorid);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
    public void frameWebElement (By locator){
        waitBot.fluentWait().until(d->{
            try {
                d.switchTo().frame(d.findElement(locator));
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
    public void frameDefault(){
        waitBot.fluentWait().until(d->{
            try {
                d.switchTo().defaultContent();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

}
