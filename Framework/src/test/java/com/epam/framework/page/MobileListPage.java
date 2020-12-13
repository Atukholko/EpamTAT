package com.epam.framework.page;

import com.epam.framework.wait.CustomWaits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileListPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.21vek.by/mobile/";

    @FindBy(xpath = "//*[@id='j-result-page-1']/descendant-or-self::*[@class='result__name']")
    private WebElement firstProductInList;

    public MobileListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ProductPage openFirstProductPage(){
        firstProductInList.click();
        CustomWaits.waitForPageLoaded(driver);
        return new ProductPage(driver);
    }

    @Override
    public MobileListPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Mobiles list page opened");
        return this;
    }
}
