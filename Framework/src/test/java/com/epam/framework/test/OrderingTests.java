package com.epam.framework.test;


import com.epam.framework.model.ProductWithPromoCode;
import com.epam.framework.page.CartPage;
import com.epam.framework.page.ProductPage;
import com.epam.framework.service.ProductWithPromoCodeCreator;
import com.epam.framework.util.IntegerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderingTests extends CommonConditions {
    ProductWithPromoCode product = ProductWithPromoCodeCreator.withUrlAndPromoCodeFromProperty();

    @Test
    public void promoCodeTest(){
        product.setPromoCode("СНЕЖНО");
        CartPage cart = new ProductPage(driver, product.getUrl())
                .openPage()
                .addToCart()
                .openCart()
                .inputPromoCode(product.getPromoCode())
                .applyPromoCode();

        int oldPrice = IntegerUtil.parsePrice(cart.getOldPrice());
        int totalPrice = IntegerUtil.parsePrice(cart.getTotalCost());

        Assert.assertTrue(oldPrice > totalPrice);
    }

    @Test
    public void removalOfDiscountChoosingInstallment(){
        product.setPromoCode("СНЕЖНО");
        CartPage cart = new ProductPage(driver, product.getUrl())
                .openPage()
                .addToCart()
                .openCart()
                .inputPromoCode(product.getPromoCode())
                .applyPromoCode()
                .checkout()
                .chooseCardInstallment()
                .closeDialog();

        int oldPrice = IntegerUtil.parsePrice(cart.getPrice());
        int totalPrice = IntegerUtil.parsePrice(cart.getTotalCost());

        Assert.assertTrue(oldPrice == totalPrice);
    }

    @Test
    public void removalOfDiscountChoosingPaymentInParts(){
        product.setPromoCode("СНЕЖНО");
        CartPage cart = new ProductPage(driver, product.getUrl())
                .openPage()
                .addToCart()
                .openCart()
                .inputPromoCode(product.getPromoCode())
                .applyPromoCode()
                .checkout()
                .choosePaymentInParts()
                .closeDialog();

        int oldPrice = IntegerUtil.parsePrice(cart.getPrice());
        int totalPrice = IntegerUtil.parsePrice(cart.getTotalCost());

        Assert.assertTrue(oldPrice == totalPrice);
    }

    @Test
    public void CertificateTest(){
        String orderTotal = new ProductPage(driver, product.getUrl())
                .openPage()
                .addToCart()
                .openCart()
                .checkout()
                .chooseCertificate()
                .inputCertificate("100")
                .getOrderTotal();

        Assert.assertEquals(orderTotal, "0");
    }
}
