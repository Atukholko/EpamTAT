package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.CustomConditions;

public class ProductListPage {
    public static final String PRODUCT_PAGE_URL = "https://www.21vek.by/mobile";
    private final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='j-result-page-1']/descendant-or-self::*[@class='result__name']")
    private WebElement product;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, WAIT_TIMEOUT_SECONDS), this);
    }

    public ProductListPage openPage(){
        driver.get(PRODUCT_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public ProductPage openProductPage(){
        product.click();
        return new ProductPage(driver);
    }
}
