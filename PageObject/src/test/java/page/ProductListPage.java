package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.CustomWaits;

public class ProductListPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='j-result-page-1']/descendant-or-self::*[@class='result__name']")
    private WebElement product;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage openProductPage(){
        product.click();
        CustomWaits.waitForPageLoaded(driver);
        return new ProductPage(driver);
    }

    @Override
    public ProductListPage openPage(String url) {
        driver.get(url);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
