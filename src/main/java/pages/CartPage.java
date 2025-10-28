package pages;

import logs.LogsManager;
import Uitils.ActionBot;
import Validation.Validation;
import Validation.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;
    private final Verification verification;
    private final ActionBot actionBot;
    private final Validation validation;

    public CartPage(WebDriver driver){
        this.driver=driver;
        this.actionBot = new ActionBot(driver);
        this.verification=new Verification(driver);
        this.validation=new Validation(driver);
    }
    private final By checkoutButton= By.xpath("//a[text()='Proceed To Checkout']");
    private final By emptyCart = By.xpath("//b[.='Cart is empty!']");
    private By productName (String productName){
        return By.xpath("(//h4 /a[text()='"+productName+"'])[1]");
    }
    private By productPrice (String productName){
        return By.xpath("(//h4 /a[text()='"+productName+"']//following::td[@class='cart_price'] /p)[1]");
    }
    private By productQuantity (String productName){
        return By.xpath("(//h4 /a[text()='"+productName+"']//following::td[@class='cart_quantity'] /button)[1]");
    }
    private By productTotal (String productName){
        return By.xpath("(//h4 /a[text()='"+productName+"']//following::td[@class='cart_total'] /p)[1]");
    }
    private By removeProduct (String productName){
        return By.xpath("//tr[.//a[contains(text(),'" + productName +"')]]//a[contains(@class,'cart_quantity_delete')]");
    }
    public void clickOnCheckout (){
        actionBot.click(checkoutButton);
    }
    public void verifyEmptyCart(){
        actionBot.click(emptyCart);
    }
    public void clickOnRemoveProduct(String productName){
        actionBot.click(removeProduct(productName));
    }
    public void verifyProductDetailsOnCart(String pName, String pPrice, String pQuantity, String pTotal) {
        LogsManager.info("🔍 Verifying product details in cart for product: " + pName);
        String actualName = actionBot.getText(productName(pName));
        String actualPrice = actionBot.getText(productPrice(pName));
        String actualQuantity = actionBot.getText(productQuantity(pName));
        String actualTotal = actionBot.getText(productTotal(pName));
        LogsManager.info("Expected vs Actual -> Name: " + pName + " / " + actualName);
        LogsManager.info("Expected vs Actual -> Price: " + pPrice + " / " + actualPrice);
        LogsManager.info("Expected vs Actual -> Quantity: " + pQuantity + " / " + actualQuantity);
        LogsManager.info("Expected vs Actual -> Total: " + pTotal + " / " + actualTotal);

        validation.assertEquals(actualName, pName, "❌ Actual name does not match expected name.");
        validation.assertEquals(actualPrice, pPrice, "❌ Actual price does not match expected price.");
        validation.assertEquals(actualQuantity, pQuantity, "❌ Actual quantity does not match expected quantity.");
        validation.assertEquals(actualTotal, pTotal, "❌ Actual total does not match expected total.");
    }


}
