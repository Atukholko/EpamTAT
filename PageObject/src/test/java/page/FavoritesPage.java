package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.CustomConditions;
import wait.CustomWaits;

public class FavoritesPage extends AbstractPage{

    private By productLocator;

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isProductOnPage(String code){
        productLocator = By.xpath("//*[text()=\'" + code + "\']");
        try{
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(productLocator));
        }catch (TimeoutException e){
            return false;
        }
        return true;
    }

    @Override
    public FavoritesPage openPage(String url) {
        driver.get(url);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
