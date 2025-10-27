package pages;
import logs.LogsManager;
import Uitils.ActionBot;
import Uitils.Alerts;
import Validation.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
    private final WebDriver driver;
    private final Verification verification;
    private final ActionBot actionBot;
    private final Alerts alerts;

    public ContactPage(WebDriver driver){
        this.driver = driver;
        this.actionBot = new ActionBot(driver);
        this.verification = new Verification(driver);
        this.alerts = new Alerts(driver);
    }
    private final By nameForm = By.xpath("//input[@name='name']");
    private final By emailForm = By.xpath("//input[@name='email']");
    private final By subjectForm = By.xpath("//input[@name='subject']");
    private final By messageForm = By.id("message");
    private final By fileForm = By.xpath("//input[@name='upload_file']");
    private final By submit = By.xpath("//input[@name='submit']");
    private final By messageSuccess = By.xpath("(//div[.='Success! Your details have been submitted successfully.'])[1]");

    public void fillFormContact(String name, String email, String subject, String message, String file) {
        LogsManager.info("📝 Starting to fill the Contact Us form.");

        LogsManager.info("Typing Name: " + name);
        actionBot.sendKeys(nameForm, name);

        LogsManager.info("Typing Email: " + email);
        actionBot.sendKeys(emailForm, email);

        LogsManager.info("Typing Subject: " + subject);
        actionBot.sendKeys(subjectForm, subject);

        LogsManager.info("Typing Message: " + message);
        actionBot.sendKeys(messageForm, message);

        LogsManager.info("Uploading File: " + file);
        actionBot.sendKeys(fileForm, file);

        LogsManager.info("Clicking on Submit button.");
        actionBot.click(submit);

        LogsManager.info("Accepting alert popup (if displayed).");
        alerts.acceptalerts();

        LogsManager.info("Verifying that the success message is displayed.");
        verification.elementIsDisplayed(messageSuccess);

        LogsManager.info("✅ Contact form submitted successfully.");
    }

}
