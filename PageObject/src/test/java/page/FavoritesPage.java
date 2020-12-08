package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritesPage {

    private final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;

    private By productLocator;

    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
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
}
