package com.epam.framework.test;

import com.epam.framework.model.Smartphone;
import com.epam.framework.page.MobileListPage;
import com.epam.framework.page.ProductPage;
import com.epam.framework.service.SmartphoneCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends CommonConditions{
    private Smartphone smartphone = SmartphoneCreator.withUrlAndCodeFromProperty();

    @Test
    public void addToTheCart() {
        Boolean addingToCartWorks = new ProductPage(driver, smartphone.getUrl())
                .openPage()
                .addToCart()
                .openCart()
                .isProductOnCart(smartphone.getCode());

        Assert.assertTrue(addingToCartWorks);
    }

    @Test
    public void deleteFromCart(){
        Boolean deletingFromCartWorks = !new ProductPage(driver, smartphone.getUrl())
                .openPage()
                .addToCart()
                .openCart()
                .deleteFromCart()
                .isProductOnCart(smartphone.getCode());

        Assert.assertTrue(deletingFromCartWorks);
    }
}
