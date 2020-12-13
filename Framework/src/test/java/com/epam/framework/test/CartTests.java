package com.epam.framework.test;

import com.epam.framework.page.MobileListPage;
import com.epam.framework.page.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends CommonConditions{

    @Test
    public void addToTheCart() {
        ProductPage productPage = new MobileListPage(driver)
                .openPage()
                .openFirstProductPage();

        String productCode = productPage.getProductCode();

        Boolean addingToCartWorks = productPage
                .addToCart()
                .openCart()
                .isProductOnCart(productCode);

        Assert.assertTrue(addingToCartWorks);
    }

}
