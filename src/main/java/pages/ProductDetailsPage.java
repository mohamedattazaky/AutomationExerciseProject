package pages;

import Uitils.ActionBot;
import Validation.Validation;
import Validation.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private final WebDriver driver;
    private final Verification verification;
    private final ActionBot actionBot;
    private final Validation validation;

    public ProductDetailsPage(WebDriver driver){
        this.driver=driver;
        this.actionBot = new ActionBot(driver);
        this.verification=new Verification(driver);
        this.validation=new Validation(driver);
    }
    private final By nameProduct =By.cssSelector(".product-information h2");
    private final By priceProduct = By.cssSelector(".product-information > span > span");
    private final By nameR = By.id("name");
    private final By emailR = By.id("email");
    private final By reviewTextarea = By.id("review");
    private final By reviewButton = By.id("button-review");
    private final By verifyReview = By.xpath("//span[text()='Thank you for your review.']");

    public void fillReview( String name, String email, String review){
        actionBot.sendKeys(nameR,name);
        actionBot.sendKeys(emailR,email);
        actionBot.sendKeys(reviewTextarea,review);
        actionBot.click(reviewButton);
    }
    public void verifyReviewSubmit(String expectedReview) {
        String actualReview = actionBot.getText(verifyReview);
        verification.assertEquals(
                actualReview,
                expectedReview,
                "❌ The submitted review text does not match the expected review."
        );
    }

    public void verifyProductDetails(String expectedName, String expectedPrice) {
        String actualName = actionBot.getText(nameProduct);
        String actualPrice = actionBot.getText(priceProduct);

        validation.assertEquals(
                actualName,
                expectedName,
                "❌ Product name displayed on the page does not match the expected name."
        );

        validation.assertEquals(
                actualPrice,
                expectedPrice,
                "❌ Product price displayed on the page does not match the expected price."
        );
    }

}
