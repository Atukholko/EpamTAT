package test;

import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CartPage;
import page.ProductListPage;
import page.ProductPage;

public class FavoritesAndPromoCodeTest {

    private WebDriver driver;

    @Before
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void favoritesTest(){
        SoftAssertions softAssertions = new SoftAssertions();
        final String MOBILE_LIST_PAGE_URL = "https://www.21vek.by/mobile";

        ProductPage productPage = new ProductListPage(driver)
                .openPage(MOBILE_LIST_PAGE_URL)
                .openProductPage()
                .skipNotification();

        String textBefore = productPage.getFavoritesButtonText();
        String colorBefore = productPage.getStarColor();
        String countBefore = productPage.getFavoritesCount();

        productPage.addToFavorites();

        softAssertions.assertThat(productPage
                .isFavoritesButtonTextChanged(textBefore))
                .isEqualTo(true);
        softAssertions.assertThat(productPage
                .isStarColorChanged(colorBefore))
                .isEqualTo(true);
        softAssertions.assertThat(productPage
                .isFavoritesCountChanged(countBefore))
                .isEqualTo(true);
        Assert.assertTrue(productPage
                .openFavoritesPage()
                .isProductOnPage(productPage.getProductCode()));
    }

    @Test
    public void promoCodeTest(){
        final String PROMO_CODE = "КНИГИ";
        final String BOOK_URL = "https://www.21vek.by/nonfiction_books/eksmo_03251.html";
        CartPage cart = new ProductPage(driver)
                .openPage(BOOK_URL)
                .addToCart()
                .openCart()
                .inputPromoCode(PROMO_CODE)
                .applyPromoCode();

        int oldPrice = Integer.parseInt(cart
                .getOldPrice()
                .replaceAll("[^\\d]", ""));
        int totalPrice = Integer.parseInt(cart
                .getTotalCost()
                .replaceAll("[^\\d]", ""));
        Assert.assertTrue(oldPrice > totalPrice);
    }

    @After
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

}
