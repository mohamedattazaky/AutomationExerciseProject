package Uitils;

import org.openqa.selenium.WebDriver;

public class Alerts {
    private final WebDriver driver;
    private WaitBot waitBot;

    public Alerts(WebDriver driver){
        this.driver=driver;
        this.waitBot=new WaitBot(driver);
    }
    public void acceptalerts (){
        waitBot.fluentWait().until(d->{
            try {
                d.switchTo().alert().accept();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
    public void dismissalerts (){
        waitBot.fluentWait().until(d->{
            try {
                d.switchTo().alert().dismiss();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
    public void sendalertstext (String text){
        waitBot.fluentWait().until(d->{
            try {
                d.switchTo().alert().sendKeys(text);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
    public String getalertstext (){
       return waitBot.fluentWait().until(d->{
            try {
                String msg = d.switchTo().alert().getText();
                return !msg.isEmpty() ? msg : null;
            } catch (Exception e) {
                return null;
            }
        });
    }
}
