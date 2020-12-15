package com.epam.framework.page;


import com.epam.framework.wait.CustomWaits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private String productUrl;

    @FindBy(xpath = "//*[@class='item-tools__li cr-item-tools-putaside']//*[@class=' g-pseudo_href']")
    private WebElement addToFavoritesButton;

    @FindBy(xpath = "//*[@class='item-tools__li cr-item-tools-putaside']/a")
    private WebElement favoritesStar;

    @FindBy(className = "userToolsToggler")
    private WebElement accountButton;

    @FindBy(className = "styles_counter__1uKhm")
    private WebElement favoritesCounter;

    @FindBy(xpath = "//*[@id='react-personal']//*[text()='Избранные товары']")
    private WebElement favorites;

    @FindBy(className = "g-code")
    private WebElement productCode;

    @FindBy(xpath = "//*[@class='userToolsWrapper' or @class='userToolsWrapper active']")
    private WebElement accountButtonWrapper;

    @FindBy(xpath = "//*[@class='headerCart']/a")
    private WebElement cartButton;

    @FindBy(xpath = "//button[text()='В корзину']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"content\"]//*[@class='compare__link g-pseudo_href j-compare j-compare__in' or @class='compare__link g-pseudo_href j-compare']")
    private WebElement addToCompareButton;

    @FindBy(className = "g-counter j-compare_counter")
    private WebElement compareCount;

    By compareButtonLocator = By.xpath("//*[@id=\"content\"]//*[text()='Сравнить товары']");

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ProductPage(WebDriver driver, String productUrl) {
        super(driver);
        this.productUrl = productUrl;
        PageFactory.initElements(this.driver, this);
    }

    public String getProductCode(){
        return productCode.getText();
    }

    public String getFavoritesButtonText(){
        return addToFavoritesButton.getText();
    }

    public String getStarColor(){
        return favoritesStar.getCssValue("color");
    }

    public String getFavoritesCount(){
        return favoritesCounter.getText();
    }

    public String getCompareCount(){
        try {
            return compareCount.getText();
        }catch (NoSuchElementException exception){
            return "0";
        }
    }

    public String getCompareButtonText(){
        return addToCompareButton.getText();
    }

    public ProductPage addToFavorites(){
        addToFavoritesButton.click();
        return this;
    }

    public ProductPage addToCompare(){
        addToCompareButton.click();
        return this;
    }

    public ProductPage addToCart(){
        addToCartButton.click();
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }

    public ProductPage openUserTools(){
        accountButton.click();
        return this;
    }

    public ProductPage closeUserTools(){
        accountButton.click();
        return this;
    }

    public FavoritesPage openFavoritesPage(){
        openUserTools();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(favorites));
        favorites.click();
        CustomWaits.waitForPageLoaded(driver);
        return new FavoritesPage(driver);
    }

    public ComparisonPage openComparisonPage(){
        WebElement openCompareButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(compareButtonLocator));
        openCompareButton.click();
        CustomWaits.waitForPageLoaded(driver);
        return new ComparisonPage(driver);
    }

    public CartPage openCart(){
        cartButton.click();
        logger.info("Cart page opened");
        CustomWaits.waitForPageLoaded(driver);
        return new CartPage(driver);
    }

    public Boolean isFavoritesButtonTextChanged(String textBefore){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !getFavoritesButtonText().equals(textBefore));
        } catch (TimeoutException e){
            logger.info("Favorites button text doesnt changed");
            return false;
        }
        return true;
    }

    public Boolean isCompareButtonTextChanged(String textBefore){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !getCompareButtonText().equals(textBefore));
        } catch (TimeoutException e){
            logger.info("Compare button text doesnt changed");
            return false;
        }
        return true;
    }

    public Boolean isStarColorChanged(String colorBefore){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !getStarColor().equals(colorBefore));
        } catch (TimeoutException e){
            logger.info("Color doesnt changed");
            return false;
        }
        return true;
    }

    public Boolean isFavoritesCountChanged(String countBefore){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !getFavoritesCount().equals(countBefore));
        } catch (TimeoutException e){
            logger.info("Favorites count doesnt changed");
            return false;
        }
        return true;
    }

    public Boolean isCompareCountChanged(String countBefore){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !getCompareCount().equals(countBefore));
        } catch (TimeoutException e){
            logger.info("Compare count doesnt changed");
            return false;
        }
        return true;
    }

    @Override
    public ProductPage openPage() {
        driver.navigate().to(productUrl);
        logger.info("Product page opened");
        return this;
    }
}
