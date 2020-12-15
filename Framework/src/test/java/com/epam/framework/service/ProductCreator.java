package com.epam.framework.service;


import com.epam.framework.model.Product;

public class ProductCreator {
    public static final String TESTDATA_PRODUCT_URL = "testdata.smartphone.url";
    public static final String TESTDATA_PRODUCT_CODE = "testdata.smartphone.code";

    public static Product withUrlAndCodeFromProperty(){
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_URL),
                TestDataReader.getTestData(TESTDATA_PRODUCT_CODE));
    }

}
