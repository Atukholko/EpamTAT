package com.epam.framework.test;

import com.epam.framework.model.Product;
import com.epam.framework.page.ProductPage;
import com.epam.framework.service.ProductCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends CommonConditions{
    private Product product = ProductCreator.withUrlAndCodeFromProperty();

    @Test
    public void addToCart() {
        Boolean addingToCartWorks = new ProductPage(driver, product.getUrl())
                .openPage()
                .addToCart()
                .openCart()
                .isProductOnCart(product.getCode());

        Assert.assertTrue(addingToCartWorks);
    }

    @Test
    public void deleteFromCart(){
        Boolean deletingFromCartWorks = !new ProductPage(driver, product.getUrl())
                .openPage()
                .addToCart()
                .openCart()
                .deleteFromCart()
                .isProductOnCart(product.getCode());

        Assert.assertTrue(deletingFromCartWorks);
    }
}
