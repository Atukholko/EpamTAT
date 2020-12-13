package com.epam.framework.test;

import com.epam.framework.model.Smartphone;
import com.epam.framework.page.MobileListPage;
import com.epam.framework.page.ProductPage;
import com.epam.framework.service.SmartphoneCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends CommonConditions{
    private Smartphone smartphone = SmartphoneCreator.withUrlFromProperty();

    @Test
    public void addToTheCart() {
        ProductPage productPage = new ProductPage(driver, smartphone.getUrl())
                .openPage();

        String smartphoneCode = productPage.getProductCode();

        Boolean addingToCartWorks = productPage
                .addToCart()
                .openCart()
                .isProductOnCart(smartphoneCode);

        Assert.assertTrue(addingToCartWorks);
    }

    @Test
    public void deleteFromCart(){
        ProductPage productPage = new ProductPage(driver, smartphone.getUrl())
                .openPage();

        String smartphoneCode = productPage.getProductCode();

        Boolean deletingFromCartWorks = !productPage
                .addToCart()
                .openCart()
                .deleteFromCart()
                .isProductOnCart(smartphoneCode);

        Assert.assertTrue(deletingFromCartWorks);
    }
}
