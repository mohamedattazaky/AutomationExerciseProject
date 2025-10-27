package pages;

import Uitils.ActionBot;
import Validation.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import logs.LogsManager;
public class SignupPage {
    private final WebDriver driver;
    private final ActionBot actionBot;
    private final Verification verification;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.actionBot = new ActionBot(driver);
        this.verification = new Verification(driver);
    }

    private final By name = By.cssSelector("[id='name']");
    private final By email = By.cssSelector("[id='email']");
    private final By pass = By.cssSelector("[id='password']");
    private final By days = By.cssSelector("[id='days']");
    private final By months = By.cssSelector("[id='months']");
    private final By years = By.cssSelector("[id='years']");
    private final By newsletter = By.cssSelector("[id='newsletter']");
    private final By offers = By.cssSelector("[id='optin']");
    private final By firstname = By.cssSelector("[id='first_name']");
    private final By lastname = By.cssSelector("[id='last_name']");
    private final By company = By.cssSelector("[id='company']");
    private final By address1 = By.cssSelector("[id='address1']");
    private final By address2 = By.cssSelector("[id='address2']");
    private final By country = By.cssSelector("[id='country']");
    private final By city = By.cssSelector("[id='city']");
    private final By state = By.cssSelector("[id='state']");
    private final By zipcode = By.cssSelector("[id='zipcode']");
    private final By mobile = By.cssSelector("[id='mobile_number']");
    private final By createBtn = By.cssSelector("[data-qa='create-account']");
    private final By accountCreated = By.tagName("p");
    private final By continueBtn = By.cssSelector("[data-qa='continue-button']");
    private final By verifyError = By.xpath("//b[.='Enter Account Information']");

    public void chooseTitle(String title) {
        LogsManager.info("👤 Selecting title: " + title);
        By titleLocator = By.cssSelector("[value='" + title + "']");
        actionBot.click(titleLocator);
        LogsManager.info("✅ Title selected successfully.");
    }

    public void fillSignup(
            String title, String password, String day, String month, String year,
            String fname, String lname, String companytext, String addressone, String adresstwo,
            String countrytext, String statetext, String citytext, String zip, String mobileNumber) {

        LogsManager.info("🧾 Starting signup form filling...");

        chooseTitle(title);
        LogsManager.info("➡️ Entered title: " + title);

        LogsManager.info("➡️ Entering password.");
        actionBot.sendKeys(pass, password);

        LogsManager.info("➡️ Selecting date of birth: " + day + "/" + month + "/" + year);
        actionBot.selectFromDropDown(days, day);
        actionBot.selectFromDropDown(months, month);
        actionBot.selectFromDropDown(years, year);

        LogsManager.info("➡️ Selecting newsletter and special offers checkboxes.");
        actionBot.click(newsletter);
        actionBot.click(offers);

        LogsManager.info("➡️ Entering personal details...");
        actionBot.sendKeys(firstname, fname);
        actionBot.sendKeys(lastname, lname);

        LogsManager.info("➡️ Entering company: " + companytext);
        actionBot.sendKeys(company, companytext);

        LogsManager.info("➡️ Entering address line 1: " + addressone);
        actionBot.sendKeys(address1, addressone);

        LogsManager.info("➡️ Entering address line 2: " + adresstwo);
        actionBot.sendKeys(address2, adresstwo);

        LogsManager.info("➡️ Selecting country: " + countrytext);
        actionBot.selectFromDropDown(country, countrytext);

        LogsManager.info("➡️ Entering state: " + statetext);
        actionBot.sendKeys(state, statetext);

        LogsManager.info("➡️ Entering city: " + citytext);
        actionBot.sendKeys(city, citytext);

        LogsManager.info("➡️ Entering zip code: " + zip);
        actionBot.sendKeys(zipcode, zip);

        LogsManager.info("➡️ Entering mobile number: " + mobileNumber);
        actionBot.sendKeys(mobile, mobileNumber);

        LogsManager.info("✅ All signup fields filled successfully.");
    }

    public void clickCreateBtn() {
        LogsManager.info("🟢 Clicking on 'Create Account' button.");
        actionBot.click(createBtn);
        LogsManager.info("✅ 'Create Account' button clicked successfully.");
    }

    public void verifyAccountCreated() {
        LogsManager.info("🔍 Verifying that account creation confirmation is displayed...");
        verification.elementIsDisplayed(accountCreated);
        LogsManager.info("✅ Account created confirmation is displayed successfully.");
    }

    public void clickContinueBtn() {
        LogsManager.info("➡️ Clicking on 'Continue' button after account creation.");
        actionBot.click(continueBtn);
        LogsManager.info("✅ Continue button clicked successfully.");
    }

    public void verifyError() {
        LogsManager.info("🔍 Verifying that error message is displayed for invalid signup...");
        verification.elementIsDisplayed(verifyError);
        LogsManager.info("✅ Error message displayed as expected.");
    }
}
