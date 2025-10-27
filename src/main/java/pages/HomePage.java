package pages;
import logs.LogsManager;
import Uitils.ActionBot;
import Validation.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final Verification verification;
    private final ActionBot actionBot;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actionBot = new ActionBot(driver);
        this.verification = new Verification(driver);
    }

    private final By womenCategory = By.xpath("(//a[@data-toggle='collapse'])[1]");
    private final By menCategory = By.xpath("(//a[@data-toggle='collapse'])[2]");
    private final By kidsCategory = By.xpath("(//a[@data-toggle='collapse'])[3]");

    private By brand(String brandName) {
        return By.xpath("//a[contains(normalize-space(.), '" + brandName + "')]");
    }

    private By subCategory(String name) {
        return By.xpath("//div[@class='panel-body']/ul/li/a[contains(normalize-space(.), '" + name + "')]");
    }

    private By subCategoryKids(String name) {
        return By.xpath("(//div[@class='panel-body']/ul/li/a[contains(normalize-space(.), '" + name + "')])[2]");

    }

    private final By subscribeMail = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By verifySubscribe = By.xpath("//div[@class='alert-success alert']");

    public void chooseBrand(String brandName) {
        LogsManager.info("🛍️ Selecting brand: " + brandName);
        actionBot.click(brand(brandName));
        LogsManager.info("✅ Brand '" + brandName + "' has been selected successfully.");
    }

    public void chooseWomenCategory(String name) {
        LogsManager.info("👗 Opening Women category.");
        actionBot.click(womenCategory);

        LogsManager.info("➡️ Selecting subcategory: " + name);
        actionBot.click(subCategory(name));

        LogsManager.info("✅ Women subcategory '" + name + "' selected successfully.");
    }

    public void chooseMenCategory(String name) {
        LogsManager.info("👕 Opening Men category.");
        actionBot.click(menCategory);

        LogsManager.info("➡️ Selecting subcategory: " + name);
        actionBot.click(subCategory(name));

        LogsManager.info("✅ Men subcategory '" + name + "' selected successfully.");
    }

    public void chooseKidsCategory(String name) {
        LogsManager.info("🧸 Opening Kids category.");
        actionBot.click(kidsCategory);

        LogsManager.info("➡️ Selecting subcategory: " + name);
        actionBot.click(subCategoryKids(name));

        LogsManager.info("✅ Kids subcategory '" + name + "' selected successfully.");
    }

    public void subscribeMail(String mail) {
        LogsManager.info("📩 Entering subscription email: " + mail);
        actionBot.sendKeys(subscribeMail, mail);

        LogsManager.info("🔘 Clicking on Subscribe button.");
        actionBot.click(subscribeButton);

        LogsManager.info("🔍 Verifying subscription confirmation message.");
        verification.elementIsDisplayed(verifySubscribe);

        LogsManager.info("✅ Subscription completed successfully for email: " + mail);
    }
}
