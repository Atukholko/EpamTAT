package com.epam.framework.page;

import com.epam.framework.wait.CustomWaits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritesPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.21vek.by/aside/";

    private By productLocator;

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isProductOnPage(String code){
        productLocator = By.xpath("//*[text()=\'код " + code + "\']");
        try{
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(productLocator));
        }catch (TimeoutException e){
            logger.info("Product not found");
            return false;
        }
        return true;
    }

    @Override
    public FavoritesPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Favorites page opened");
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
