import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class FavoritesButtonTest {
    private WebDriver driver;
    private WebElement addFavoritesButton;

    @Before
    public void setUpDriverAndClickFavoritesButton() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.21vek.by/mobile/iphone11128gbmwm22_apple.html");
        addFavoritesButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div[2]/span[3]/a/span"));
        addFavoritesButton.click();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void favoritesButtonTextChangingTest() {
        String expectedTextButton = "Удалить из избранного";
        String actualTextButton = addFavoritesButton.getText();
        Assert.assertEquals(expectedTextButton, actualTextButton);
    }

    @Test
    public void favoritesButtonStarColorChanging(){
        WebElement favoritesStar = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div[2]/span[3]/a"));
        String expectedColor = "rgba(188, 18, 66, 1)";
        String actualColor = favoritesStar.getCssValue("color");
        Assert.assertEquals(expectedColor, actualColor);
    }

    @Test
    public void favoritesCounterChanging(){
        WebElement accountButton = driver.findElement(By.xpath("//*[@id=\"j-header-react-line-two\"]/div/div[3]/div/button/span"));
        accountButton.click();
        WebElement favoritesCounter = driver.findElement(By.xpath("//*[@id=\"react-personal\"]/div/div[2]/div/span"));
        String expectedCount = "1";
        String actualCount = favoritesCounter.getText();
        Assert.assertEquals(expectedCount, actualCount);
    }

}
