package pages;

import Uitils.ActionBot;
import Validation.Validation;
import Validation.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;
    private final ActionBot actionBot;
    private final Validation validation;


    public CheckoutPage(WebDriver driver){
    this.driver = driver;
    this.actionBot = new ActionBot(driver);
    this.validation = new Validation(driver);
}
    // Delivery Address
    private final By deliveryName = By.xpath("//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']");
    private final By deliveryCompany = By.xpath("//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][1]");
    private final By deliveryAddress1 = By.xpath("//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][2]");
    private final By deliveryAddress2 = By.xpath("//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][3]");
    private final By deliveryCityStateZip = By.xpath("//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']");
    private final By deliveryCountry = By.xpath(" //ul[@id='address_delivery']//li[@class='address_country_name']");
    private final By deliveryPhone = By.xpath(" //ul[@id='address_delivery']//li[@class='address_phone']");


    //Billing Address
 private final By billingName = By.xpath("//ul[@id='address_invoice']//li[@class='address_firstname address_lastname']");
    private final By billingCompany = By.xpath("//ul[@id='address_invoice']//li[@class='address_address1 address_address2'][1]");
    private final By billingAddress1 = By.xpath("//ul[@id='address_invoice']//li[@class='address_address1 address_address2'][2]");
    private final By billingAddress2 = By.xpath("//ul[@id='address_invoice']//li[@class='address_address1 address_address2'][3]");
    private final By billingCityStateZip = By.xpath("//ul[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']");
    private final By billingCountry = By.xpath(" //ul[@id='address_invoice']//li[@class='address_country_name']");
    private final By billingPhone = By.xpath(" //ul[@id='address_invoice']//li[@class='address_phone']");

    //
    private final By placeOrderButton = By.xpath("//a[.='Place Order']");

    public void navigate (){
        driver.navigate().to("https://automationexercise.com/checkout");
    }

    public void verifyDeliveryAddress (String title, String fName, String lName, String company,String address1,String address2,String city,String state,String zip,String country, String phone) {
        validation.assertEquals(
                actionBot.getText(deliveryName),
                (title + ". " + fName + " " + lName),
                "❌ Delivery name does not match the expected full name."
        );

        validation.assertEquals(
                actionBot.getText(deliveryCompany),
                company,
                "❌ Delivery company name is incorrect."
        );

        validation.assertEquals(
                actionBot.getText(deliveryAddress1),
                address1,
                "❌ Delivery Address Line 1 does not match the expected value."
        );

        validation.assertEquals(
                actionBot.getText(deliveryAddress2),
                address2,
                "❌ Delivery Address Line 2 does not match the expected value."
        );

        validation.assertEquals(
                actionBot.getText(deliveryCityStateZip),
                (zip + " " + city + " " + state),
                "❌ City, State, or ZIP code in delivery details is incorrect."
        );

        validation.assertEquals(
                actionBot.getText(deliveryCountry),
                country,
                "❌ Delivery country does not match the expected country."
        );

        validation.assertEquals(
                actionBot.getText(deliveryPhone),
                phone,
                "❌ Delivery phone number is incorrect."
        );


    }
    public void verifyBillingAddress (String title, String fName, String lName, String company,String address1,String address2,String city,String state,String zip,String country, String phone) {
        validation.assertEquals(actionBot.getText(billingName), (title + ". " + fName + " " + lName), "Actual name does not expected name");
        validation.assertEquals(actionBot.getText(billingCompany), company, "Actual company does not expected company");
        validation.assertEquals(actionBot.getText(billingAddress1), address1, "Actual address 1 does not expected");
        validation.assertEquals(actionBot.getText(billingAddress2),address2,"Actual address 2 does not expected" );
        validation.assertEquals(actionBot.getText(billingCityStateZip),(zip+" "+city+" "+state),"Actual city and state , zip does not match expected");
        validation.assertEquals(actionBot.getText(billingCountry),country,"Actual country does not expected country" );
        validation.assertEquals(actionBot.getText(billingPhone),phone,"Actual phone does not expected phone" );

    }
 public void clickOnPlaceOrderButton (){
        actionBot.click(placeOrderButton);
 }


}
