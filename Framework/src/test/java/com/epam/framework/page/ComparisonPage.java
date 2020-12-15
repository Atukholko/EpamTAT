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

public class ComparisonPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.21vek.by/mobile/compare/";

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isProductOnPage(String productCode){
        By productLocator = By.xpath("//*[text()='код " + productCode + "']");
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
    public ComparisonPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Comparison page opened");
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
