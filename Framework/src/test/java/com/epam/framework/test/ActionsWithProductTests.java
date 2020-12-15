package com.epam.framework.test;

import com.epam.framework.model.Product;
import com.epam.framework.page.ProductPage;
import com.epam.framework.service.ProductCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ActionsWithProductTests extends CommonConditions{
    private Product product = ProductCreator.withUrlAndCodeFromProperty();
    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void AddingToFavoritesTest(){

        ProductPage productPage = new ProductPage(driver, product.getUrl())
                .openPage();

        String textBefore = productPage.getFavoritesButtonText();
        String colorBefore = productPage.getStarColor();
        String countBefore = productPage.getFavoritesCount();

        productPage.addToFavorites();

        softAssert.assertTrue(productPage.isFavoritesButtonTextChanged(textBefore));
        softAssert.assertTrue(productPage.isStarColorChanged(colorBefore));
        softAssert.assertTrue(productPage.isFavoritesCountChanged(countBefore));
        Assert.assertTrue(productPage
                .openFavoritesPage()
                .isProductOnPage(product.getCode()));
    }

    @Test
    public void addingToComparison(){
        ProductPage productPage = new ProductPage(driver, product.getUrl())
                .openPage();

        String textBefore = productPage.getCompareButtonText();
        String countBefore = productPage.getCompareCount();

        productPage.addToCompare();

        softAssert.assertTrue(productPage.isCompareButtonTextChanged(textBefore));
        softAssert.assertTrue(productPage.isCompareCountChanged(countBefore));
        Assert.assertTrue(productPage
                .openComparisonPage()
                .isProductOnPage(product.getCode()));
    }
}
