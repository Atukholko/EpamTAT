package com.epam.framework.page;

import com.epam.framework.wait.CustomWaits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage inputPromoCode(String promoCode){
        promoCodeInput.sendKeys(promoCode);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until((WebDriver driver) -> promoCodeInput.getAttribute("value").equals(promoCode));
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

    public Boolean isProductOnCart(String productCode){
        By productLocator = By.xpath("//*[text()=\'" + productCode + "\']");
        try{
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(productLocator));
        }catch (TimeoutException e){
            return false;
        }
        return true;
    }

    @Override
    public CartPage openPage() {
        driver.navigate().to(BASE_URL);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
