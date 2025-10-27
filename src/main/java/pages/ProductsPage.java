package pages;

import Uitils.ActionBot;
import Validation.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private final WebDriver driver;
    Verification verification;
    ActionBot actionBot;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.actionBot = new ActionBot(driver);
        this.verification = new Verification(driver);
    }
    private final By searchField = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By continueShopping = By.xpath("//button[text()='Continue Shopping']");
    private final By addedCartLabel = By.xpath("//p[text()='Your product has been added to cart.']");
    private final By viewCart = By.xpath("//u[text()='View Cart']");
    private final By proceedToCheckout = By.xpath("//a[.='Proceed To Checkout']");
    private final By quantityIncrease = By.id("quantity");
    private final By addToCartAfterQuantity = By.xpath("//button[@class='btn btn-default cart']");

    private By productName (String productName){
        return By.xpath("//div[@class='overlay-content']//p[text()='"+productName+"']");
    }
    private By productPrice (String productName){
        return By.xpath("//div[@class='overlay-content']//p[text()='"+productName+"']//preceding-sibling::h2");
    }
    private By productQuantity (String productName){
        return By.xpath("//tr[.//a[contains(text(),'" + productName + "')]]//td[@class='cart_quantity']//button");
    }
    private By addToCart (String productName){
        return By.xpath("//div[@class='overlay-content']//p[text()='"+productName+"']//following-sibling::a");
    }
    private By hoverOnProduct(String productName){
        return By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']");
    }
    private By viewProduct(String productName){
        return By.xpath("//p[text()='"+productName+"']//following::a[text()='View Product'][1]");
    }
    public void searchProduct(String productName){
        actionBot.sendKeys(searchField,productName);
        actionBot.click(searchButton);
    }
    public void clickOnAddToCart(String productName){
        actionBot.hover(hoverOnProduct(productName));
        actionBot.click(addToCart(productName));
    }
    public void verifyQuantity(String qNumber, String productName){
        actionBot.sendKeys(quantityIncrease, qNumber);
        actionBot.click(addToCartAfterQuantity);
        clickOnViewCart();
        String actualQuantity = actionBot.getText(productQuantity(productName));
        verification.assertEquals(actualQuantity,qNumber,"Quantity in cart does not match expected value");
    }
    public void clickOnViewProduct(String productName){
        actionBot.click(viewProduct(productName));
    }
    public void clickOnViewCart(){
        actionBot.click(viewCart);
    }
    public void clickOnContinueShopping(){
        actionBot.click(continueShopping);
    }
    public void verifySearchProduct(String productName) {
        actionBot.hover(hoverOnProduct(productName));
        String actual = actionBot.getText(productName(productName));
        verification.assertEquals(
                actual,
                productName,
                "❌ The displayed product name after search does not match the expected product."
        );
    }

    public void verifyAddedToCart(String expected) {
        String actual = actionBot.getText(addedCartLabel);
        verification.assertEquals(
                actual,
                expected,
                "❌ The 'Added to Cart' confirmation message does not match the expected text."
        );
    }

    public void clickOnProceedToCheckOut(){
        actionBot.click(proceedToCheckout);
    }
}
