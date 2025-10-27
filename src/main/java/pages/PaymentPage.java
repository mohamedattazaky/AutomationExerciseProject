package pages;
import logs.LogsManager;
import Uitils.ActionBot;
import Validation.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;
    Verification verification;
    ActionBot actionBot;

    public PaymentPage(WebDriver driver) {
        this.actionBot = new ActionBot(driver);
        this.verification = new Verification(driver);
    }

    private final By nameOnCard = By.name("name_on_card");
    private final By cardNumber = By.name("card_number");
    private final By cardCvc = By.name("cvc");
    private final By cardMonthExpiration = By.name("expiry_month");
    private final By cardYearExpiration = By.name("expiry_year");
    private final By payButton = By.id("submit");
    private final By downloadInvoice = By.xpath("//a[.='Download Invoice']");
    private final By verifyPaymentSuccess = By.xpath("//p[.='Congratulations! Your order has been confirmed!']");

    public void fillPayment(String name, String number, String cvc, String month, String year) {
        LogsManager.info("💳 Starting to fill payment details...");

        LogsManager.info("➡️ Entering Name on Card: " + name);
        actionBot.sendKeys(nameOnCard, name);

        LogsManager.info("➡️ Entering Card Number: " + number);
        actionBot.sendKeys(cardNumber, number);

        LogsManager.info("➡️ Entering CVC: " + cvc);
        actionBot.sendKeys(cardCvc, cvc);

        LogsManager.info("➡️ Entering Expiration Month: " + month);
        actionBot.sendKeys(cardMonthExpiration, month);

        LogsManager.info("➡️ Entering Expiration Year: " + year);
        actionBot.sendKeys(cardYearExpiration, year);

        LogsManager.info("🟢 Clicking Pay button to complete payment.");
        actionBot.click(payButton);

        LogsManager.info("✅ Payment details submitted successfully.");
    }

    public void verifyPayment(String expectedMessage) {
        LogsManager.info("🔍 Verifying payment success message...");
        String actualMessage = actionBot.getText(verifyPaymentSuccess);
        LogsManager.info("📄 Actual message displayed: " + actualMessage);

        verification.assertEquals(
                actualMessage,
                expectedMessage,
                "❌ Payment confirmation message does not match the expected text."
        );

        LogsManager.info("✅ Payment message verified successfully — Transaction confirmed.");
    }

    public void clickOnDownloadInvoice() {
        LogsManager.info("📥 Clicking on 'Download Invoice' button.");
        actionBot.click(downloadInvoice);
        LogsManager.info("✅ Invoice downloaded successfully.");
    }
}
