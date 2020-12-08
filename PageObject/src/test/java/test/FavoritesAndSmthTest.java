package test;

import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.FavoritesPage;
import page.ProductListPage;
import page.ProductPage;

public class FavoritesAndSmthTest {

    private WebDriver driver;
    private SoftAssertions softAssertions;

    @Before
    public void browserSetup(){
        driver = new ChromeDriver();
        softAssertions = new SoftAssertions();
    }

    @Test
    public void favoritesTest(){
        String expectedTextButton = "Удалить из избранного";
        String expectedColor = "rgba(188, 18, 66, 1)";
        String expectedCount = "1";

        ProductPage productPage = new ProductListPage(driver)
                .openPage()
                .openProductPage();
        productPage.addToFavorites();

        String actualTextButton = productPage.getFavoritesButtonText();
        softAssertions.assertThat(actualTextButton).isEqualTo(expectedTextButton);

        String actualColor = productPage.getStarColor();
        softAssertions.assertThat(actualColor).isEqualTo(expectedColor);

        String actualCount = productPage.getFavoritesCount();
        softAssertions.assertThat(actualCount).isEqualTo(expectedCount);

        Boolean actualExisting = productPage.openFavoritesPage().isProductOnPage(productPage.getProductCode());
        Assert.assertTrue(actualExisting);
    }

    @After
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

}
