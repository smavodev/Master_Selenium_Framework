package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    private final By firstNameField =  By.id("billing_first_name");
    private final By lastNameField =  By.id("billing_last_name");
    private final By CompanyNameField =  By.id("billing_company");
    private final By countrySelector =  By.xpath("//span[@id='select2-billing_country-container']");
    private final By address_1 =  By.id("billing_address_1");
    private final By address_2 =  By.id("billing_address_2");
    private final By cityField = By.id("billing_city");
    private final By stateSelector = By.xpath("//span[@id='select2-billing_state-container']");
    private final By enterPostcode = By.id("billing_postcode");
    private final By enterPhone = By.id("billing_phone");
    private final By enterEmail = By.id("billing_email");
    private final By enterComments =  By.id("order_comments");
    private final By paymentMethod = By.xpath("//input[@id='payment_method_cod']"); // //input[@id='payment_method_bacs']
    private final By placeOrder = By.id("place_order");
    private final By checkoutOrderTitle = By.xpath("//h1[contains(.,'Checkout')]");
    private final By checkoutOrderText = By.xpath("//p[contains(.,'Thank you. Your order has been received.')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstname){
        driver.findElement(firstNameField).sendKeys(firstname);
        return this;
    }

    public CheckoutPage enterLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterCompanyName(String companyName){
        driver.findElement(CompanyNameField).sendKeys(companyName);
        return this;
    }

    public CheckoutPage SelectCountry(String country){
        By SelectCountry =  By.xpath("//span/ul/li[contains(.,'"+country+"')]");
        driver.findElement(countrySelector).click();
        driver.findElement(SelectCountry).click();
        return this;
    }

    public CheckoutPage enterAddress_1(String Address1){
        driver.findElement(address_1).sendKeys(Address1);
        return this;
    }

    public CheckoutPage enterAddress_2(String Address2){
        driver.findElement(address_2).sendKeys(Address2);
        return this;
    }

    public CheckoutPage clickCity(String city){
        driver.findElement(cityField).sendKeys(city);
        return this;
    }

    public CheckoutPage SelectState(String state){
        By SelectState =  By.xpath("//ul/li[@class='select2-results__option'][contains(.,'"+state+"')]");
        driver.findElement(stateSelector).click();
        driver.findElement(SelectState).click();
        return this;
    }

    public CheckoutPage enterPostcodeField(String postcode){
        driver.findElement(enterPostcode).sendKeys(postcode);
        return this;
    }

    public CheckoutPage enterPhoneField(String phone){
        driver.findElement(enterPhone).sendKeys(phone);
        return this;
    }

    public CheckoutPage enterEmailField(String email){
        driver.findElement(enterEmail).sendKeys(email);
        return this;
    }

    public CheckoutPage enterCommentsField(String comments, Integer tiempo) throws InterruptedException{
        driver.findElement(enterComments).sendKeys(comments);
        Thread.sleep(tiempo);
        return this;
    }

    public CheckoutPage ClickPaymentMethod(Integer tiempo) throws InterruptedException{
        driver.findElement(paymentMethod).click() ;
        Thread.sleep(tiempo);
        return this;
    }

    public CheckoutPage ClickPlaceOrder(Integer tiempo) throws InterruptedException{
        driver.findElement(placeOrder).click() ;
        Thread.sleep(tiempo);
        return this;
    }

    public void getTitleCheckoutValid(String txtTitle, String txtSubTitle) {
        driver.findElement(checkoutOrderTitle).getText();
        driver.findElement(checkoutOrderText).getText();
        Assert.assertEquals(
                driver.findElement(checkoutOrderTitle).getText(),txtTitle
        );
        Assert.assertEquals(
                driver.findElement(checkoutOrderText).getText(),txtSubTitle
        );

    }

}
