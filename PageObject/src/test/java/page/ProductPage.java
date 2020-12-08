package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;

    @FindBy(xpath = "//*[@class=\"item-tools__li cr-item-tools-putaside\"]//*[@class=\" g-pseudo_href\"]")
    private WebElement addToFavoritesButton;

    @FindBy(xpath = "//*[@class=\"item-tools__li cr-item-tools-putaside\"]/a")
    private WebElement favoritesStar;

    @FindBy(className = "userToolsToggler")
    private WebElement accountButton;

    @FindBy(className = "styles_counter__1uKhm")
    private WebElement favoritesCounter;

    @FindBy(xpath = "//*[@id=\"react-personal\"]//*[text()=\"Избранные товары\"]")
    private WebElement favorites;

    @FindBy(className = "g-code")
    private WebElement productCode;

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

    public WebElement openAccount(){
        accountButton.click();
        return accountButton;
    }

    public FavoritesPage openFavoritesPage(){
        openAccount();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-personal\"]//*[text()=\"Избранные товары\"]")));
        favorites.click();
        return new FavoritesPage(driver);
    }

    public String getFavoritesCount(){
        return favoritesCounter.getText();
    }

    public String getProductCode(){
        return productCode.getText();
    }
}
