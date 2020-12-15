package com.epam.framework.service;

import com.epam.framework.model.ProductWithPromoCode;

public class ProductWithPromoCodeCreator {
    public static final String TESTDATA_PRODUCT_URL = "testdata.productwithpromocode.url";
    public static final String TESTDATA_PRODUCT_CODE = "testdata.productwithpromocode.promocode";

    public static ProductWithPromoCode withUrlAndPromoCodeFromProperty(){
        return new ProductWithPromoCode(TestDataReader.getTestData(TESTDATA_PRODUCT_URL),
                TestDataReader.getTestData(TESTDATA_PRODUCT_CODE));
    }
}
