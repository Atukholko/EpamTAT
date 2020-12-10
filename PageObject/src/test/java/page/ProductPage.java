package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.CustomWaits;


public class ProductPage {
    private final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;

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

    @FindBy(xpath = "//a[@class='headerCartBox']")
    private WebElement cartButton;

    @FindBy(xpath = "//button[text()='В корзину']")
    private WebElement addToCartButton;

    @FindBy(className = "styles_notificationActionsButton__3HYgl")
    private WebElement skipNotificationButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, WAIT_TIMEOUT_SECONDS), this);
    }

    public ProductPage openPage(String url){
        driver.get(url);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }

    public ProductPage addToFavorites(){
        addToFavoritesButton.click();
        return this;
    }

    public ProductPage addToCart(){
        addToCartButton.click();
        return this;
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

    public Boolean isFavoritesButtonTextChanged(String textBefore){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !getFavoritesButtonText().equals(textBefore));
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public Boolean isStarColorChanged(String colorBefore){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !getStarColor().equals(colorBefore));
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public Boolean isFavoritesCountChanged(String countBefore){
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until((WebDriver driver) -> !getFavoritesCount().equals(countBefore));
        } catch (TimeoutException e){
            return false;
        }
        return true;
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
        closeUserTools();
        CustomWaits.waitForPageLoaded(driver);
        return new FavoritesPage(driver);
    }

    public String getProductCode(){
        return productCode.getText();
    }

    public CartPage openCart(){
        cartButton.click();
        CustomWaits.waitForPageLoaded(driver);
        return new CartPage(driver);
    }

    public ProductPage skipNotification(){
        try{
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("styles_notificationActionsButton__3HYgl")));
            skipNotificationButton.click();
        }catch (TimeoutException e){
            System.out.println("no notifications were found");
        }
        return this;
    }
}
