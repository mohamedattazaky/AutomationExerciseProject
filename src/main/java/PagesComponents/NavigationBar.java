package PagesComponents;

import Uitils.ActionBot;
import Validation.Verification;
import logs.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final WebDriver driver;
    private final ActionBot actionBot;
    private final Verification verification;
    public NavigationBar(WebDriver driver){
        this.driver = driver;
        this.actionBot = new ActionBot(driver);
        this.verification = new Verification(driver);
    }


    private final By homeButton = By.xpath("//a[contains(text(),'Home')]");
    private final By productsButton = By.xpath("//a[contains(text(),'Products')]");
    private final By cartsButton = By.xpath("//a[contains(text(),'Cart')]");
    private final By testCasesButton = By.xpath("//a[contains(text(),'Test Cases')]");
    private final By videoButton = By.xpath("//a[contains(text(),'Video')]");
    private final By contactButton = By.xpath("//a[contains(text(),'Contact')]");
    private final By apiButton = By.xpath("//a[contains(text(),'API Testing')]");
    private final By loginButton = By.xpath("//a[contains(text(),'Login')]");
    private final By deleteAccountButton =By.xpath("//a[.=' Delete Account']");
    private final By verifyDeleteAcc = By.xpath("//p[.='Your account has been permanently deleted!']");
    private final By continueAfterDelete = By.xpath("//a[.='Continue']");
    private final By verifyHomeButton = By.xpath("//h2[contains(text(),'practice website for')]");
    private final By verifyUser = By.tagName("b");
    private final By logoutButton = By.xpath("//a[.=' Logout']");

    public void navigate(){
        driver.navigate().to("https://automationexercise.com/");
    }
    public void clickOnLogoutButton(){actionBot.click(logoutButton);}
    public void clickOnHomeButton(){
        actionBot.click(homeButton);
    }
    public void clickOnProductsButton(){
        actionBot.click(productsButton);
    }
    public void clickOnCartButton(){
        actionBot.click(cartsButton);
    }
    public void clickOnTestCasesButton(){
        actionBot.click(testCasesButton);
    }
    public void clickOnLoginButton(){
        actionBot.click(loginButton);
    }
    public void clickOnApiTestingButton(){
        actionBot.click(apiButton);
    }
    public void clickOnVideoButton(){
        actionBot.click(videoButton);
    }
    public void clickOnContactButton(){
        actionBot.click(contactButton);
    }
    public void verifyHomePage(){
        verification.elementIsDisplayed(verifyHomeButton);
    }

    public void verifyUser(String expectedName) {
        String actualName = actionBot.getText(verifyUser);
        LogsManager.info("🔍 Verifying logged-in user label: " + actualName);

        verification.assertEquals(
                actualName,
                expectedName,
                "❌ The displayed username does not match the expected user name."
        );
    }

    public void deleteAccount (){
        actionBot.click(deleteAccountButton);
   }
    public void verifyDeleteAccount(String expectedMessage) {
        String actualMessage = actionBot.getText(verifyDeleteAcc);
        verification.assertEquals(
                actualMessage,
                expectedMessage,
                "❌ The account deletion confirmation message does not match the expected text."
        );
    }

    public void clickOnContinueAfterDelete(){
        actionBot.click(continueAfterDelete);
 }
}
