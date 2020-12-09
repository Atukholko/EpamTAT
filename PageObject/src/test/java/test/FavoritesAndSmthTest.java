package test;

import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ProductListPage;
import page.ProductPage;

public class FavoritesAndSmthTest {

    private WebDriver driver;
    private SoftAssertions softAssertions;

    @Before
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssertions = new SoftAssertions();
    }

    @Test
    public void favoritesTest(){
        ProductPage productPage = new ProductListPage(driver)
                .openPage()
                .openProductPage();

        String textBefore = productPage.getFavoritesButtonText();
        String colorBefore = productPage.getStarColor();
        String countBefore = productPage.getFavoritesCount();

        productPage.addToFavorites();

        softAssertions.assertThat(productPage.isFavoritesButtonTextChanged(textBefore)).isEqualTo(true);
        softAssertions.assertThat(productPage.isStarColorChanged(colorBefore)).isEqualTo(true);
        softAssertions.assertThat(productPage.isFavoritesCountChanged(countBefore)).isEqualTo(true);
        Assert.assertTrue(productPage.openFavoritesPage().isProductOnPage(productPage.getProductCode()));
    }

    @After
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

}
