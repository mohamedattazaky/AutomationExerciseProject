package pages;
import logs.LogsManager;
import Uitils.ActionBot;
import Validation.BaseAssertion;
import Validation.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage {
    WebDriver driver;
    Verification verification;
    ActionBot actionBot;
    public SignupLoginPage(WebDriver driver){
        this.driver = driver;
        this.actionBot =new ActionBot(driver);
        this.verification = new Verification(driver);
    }
    private final By emailBtn = By.cssSelector("[data-qa='login-email']");
    private final By passBtn = By.cssSelector("[data-qa='login-password']");
    private final By loginBtn = By.cssSelector("[data-qa='login-button']");
    private final By signupNameBtn = By.cssSelector("[data-qa='signup-name']");
    private final By signupEmailBtn = By.cssSelector("[data-qa='signup-email']");
    private final By signupBtn = By.cssSelector("[data-qa='signup-button']");
    private final By loginError = By.xpath("//p[text()='Your email or password is incorrect!']");
    private final By registeredExist = By.xpath("//p[text()='Email Address already exist!']");
    private final By signupError = By.xpath("//h2[.='New User Signup!']");
    private final By errorFieldsEmpty = By.xpath("//h2[.='Login to your account']");

    public void enterLogin(String Email, String Password) {
        LogsManager.info("🔐 Starting login process...");
        LogsManager.info("➡️ Entering email: " + Email);
        actionBot.sendKeys(emailBtn, Email);

        LogsManager.info("➡️ Entering password.");
        actionBot.sendKeys(passBtn, Password);

        LogsManager.info("🟢 Clicking on Login button.");
        actionBot.click(loginBtn);

        LogsManager.info("✅ Login form submitted.");
    }

    public void enterSignup(String name, String email) {
        LogsManager.info("🧾 Starting signup process...");
        LogsManager.info("➡️ Entering name: " + name);
        actionBot.sendKeys(signupNameBtn, name);

        LogsManager.info("➡️ Entering email: " + email);
        actionBot.sendKeys(signupEmailBtn, email);

        LogsManager.info("🟢 Clicking on Signup button.");
        actionBot.click(signupBtn);

        LogsManager.info("✅ Signup form submitted.");
    }

    public void verifyErrorFieldsEmpty() {
        LogsManager.info("🔍 Verifying empty fields error message is displayed...");
        verification.elementIsDisplayed(errorFieldsEmpty);
        LogsManager.info("✅ Empty fields error message displayed successfully.");
    }

    public void verifyLoginError(String expected) {
        LogsManager.info("🔍 Verifying login error message...");
        String actual = actionBot.getText(loginError);
        LogsManager.info("📄 Actual error message: " + actual);

        verification.assertEquals(
                actual,
                expected,
                "❌ The displayed login error message does not match the expected message."
        );
        LogsManager.info("✅ Login error message verified successfully.");
    }

    public void verifySignupError() {
        LogsManager.info("🔍 Verifying signup error message is displayed...");
        verification.elementIsDisplayed(signupError);
        LogsManager.info("✅ Signup error message displayed successfully.");
    }

    public void verifySignupExist(String expected) {
        LogsManager.info("🔍 Verifying 'already registered' signup message...");
        String actual = actionBot.getText(registeredExist);
        LogsManager.info("📄 Actual message: " + actual);

        verification.assertEquals(
                actual,
                expected,
                "❌ The 'already registered' signup message does not match the expected text."
        );
        LogsManager.info("✅ 'Already registered' message verified successfully.");
    }

}
