package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.CustomWaits;

public class CartPage {
    private final int WAIT_TIMEOUT_SECONDS = 20;
    private WebDriver driver;

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
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, WAIT_TIMEOUT_SECONDS), this);
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
}
