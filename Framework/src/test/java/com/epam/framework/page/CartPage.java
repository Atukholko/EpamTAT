package com.epam.framework.page;

import com.epam.framework.wait.CustomWaits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.21vek.by/order/";

    @FindBy(xpath = "//*[text()=Оформить заказ]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@placeholder='Промокод']")
    private WebElement promoCodeInput;

    @FindBy(xpath = "//*[text()='Применить код']")
    private WebElement applyPromoCodeButton;

    @FindBy(id = "j-total_cost")
    private WebElement totalCost;

    @FindBy(className = "promo__oldprice")
    private WebElement oldPrice;

    @FindBy(id = "j-cost-4115168")
    private WebElement price;

    @FindBy(xpath = "//*[text()='Оформить заказ']")
    private WebElement checkout;

    @FindBy(xpath = "//*[text()='Закрыть']")
    private WebElement closeDialog;

    @FindBy(id = "j-prepayment")
    private WebElement certificateInput;

    @FindBy(xpath = "//*[@class='order_total']//*[@class='g-price']")
    private WebElement orderTotal;

    private By cardInstallmentLocator = By.id("card_installment");
    private By creditLocator = By.id("credit");
    private By certificateLocator = By.id("sertificate");
    private By deleteFromCartButtonLocator = By.id("j-delete-5416247");

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CartPage inputPromoCode(String promoCode){
        promoCodeInput.sendKeys(promoCode);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until((WebDriver driver) -> promoCodeInput.getAttribute("value").equals(promoCode));
        return this;
    }

    public CartPage deleteFromCart(){
        WebElement deleteFromCartButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(deleteFromCartButtonLocator));
        deleteFromCartButton.click();
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }

    public CartPage applyPromoCode(){
        applyPromoCodeButton.click();
        return this;
    }

    public String getTotalCost(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !totalCost.getText().equals(""));
        return totalCost.getText();
    }

    public String getOldPrice(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !oldPrice.getText().equals(""));
        return oldPrice.getText();
    }

    public String getPrice(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !price.getText().equals(""));
        return price.getText();
    }

    public String getOrderTotal(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !orderTotal.getText().equals(""));
        return orderTotal.getText();
    }

    public Boolean isProductOnCart(String productCode){
        By productLocator = By.xpath("//*[@id=\"j-basket__items\"]//*[text()='код " + productCode + "']");
        try{
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(productLocator));
        }catch (TimeoutException e){
            logger.info("Product not found");
            return false;
        }
        return true;
    }

    public CartPage checkout(){
        checkout.click();
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }

    public CartPage chooseCardInstallment(){
        WebElement cardInstallment = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(cardInstallmentLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", cardInstallment);
        return this;
    }

    public CartPage choosePaymentInParts(){
        WebElement credit = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(creditLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", credit);
        return this;
    }

    public CartPage chooseCertificate(){
        WebElement certificate = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(certificateLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", certificate);
        return this;
    }

    public CartPage inputCertificate(String value){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(certificateInput));
        certificateInput.sendKeys(value + "\n");
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }

    public CartPage closeDialog(){
        CustomWaits.waitForPageLoaded(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", closeDialog);
        return this;
    }

    @Override
    public CartPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Cart page opened");
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
