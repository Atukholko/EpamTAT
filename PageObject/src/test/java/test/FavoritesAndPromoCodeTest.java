package test;

import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CartPage;
import page.MobileListPage;
import page.ProductPage;

public class FavoritesAndPromoCodeTest {

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
        ProductPage productPage = new MobileListPage(driver)
                .openPage()
                .openProductPage()
                .skipNotification();

        String textBefore = productPage.getFavoritesButtonText();
        String colorBefore = productPage.getStarColor();
        String countBefore = productPage.getFavoritesCount();

        productPage.addToFavorites();

        softAssertions.assertThat(productPage.isFavoritesButtonTextChanged(textBefore)).isEqualTo(true);
        softAssertions.assertThat(productPage.isStarColorChanged(colorBefore)).isEqualTo(true);
        softAssertions.assertThat(productPage.isFavoritesCountChanged(countBefore)).isEqualTo(true);
        Assert.assertTrue(productPage.openFavoritesPage().isProductOnPage(productPage.getProductCode()));
    }

    @Test
    public void promoCodeTest(){
        final String promoCode = "КНИГИ";
        final String bookUrl = "https://www.21vek.by/nonfiction_books/eksmo_03251.html";
        CartPage cart = new ProductPage(driver)
                .openPage(bookUrl)
                .addToCart()
                .openCart()
                .inputPromoCode(promoCode)
                .applyPromoCode();

        Integer oldPrice = Integer.parseInt(cart.getOldPrice().replaceAll("[^\\d]", ""));
        Integer totalPrice = Integer.parseInt(cart.getTotalCost().replaceAll("[^\\d]", ""));
        Assert.assertTrue(oldPrice > totalPrice);
    }

    @After
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

}
