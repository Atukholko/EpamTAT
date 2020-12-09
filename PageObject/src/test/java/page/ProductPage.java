package page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final int WAIT_TIMEOUT_SECONDS = 20;
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

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, WAIT_TIMEOUT_SECONDS), this);
    }

    public WebElement addToFavorites(){
        addToFavoritesButton.click();
        return addToFavoritesButton;
    }

    public String getFavoritesButtonText(){
        return addToFavoritesButton.getText();
    }

    public String getStarColor(){
        return favoritesStar.getCssValue("color");
    }

    public String getFavoritesCount(){
        openUserTools();
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

    public WebElement openUserTools(){
        if(accountButtonWrapper.getAttribute("class").equals("userToolsWrapper"))
            accountButton.click();
        return accountButton;
    }

//    public WebElement closeUserTools(){
//        accountButton.click();
//        return accountButton;
//    }

    public FavoritesPage openFavoritesPage(){
        openUserTools();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(favorites));
        favorites.click();
        return new FavoritesPage(driver);
    }

    public String getProductCode(){
        return productCode.getText();
    }
}
