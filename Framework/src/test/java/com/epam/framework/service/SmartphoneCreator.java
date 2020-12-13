package com.epam.framework.service;


import com.epam.framework.model.Smartphone;

public class SmartphoneCreator {
    public static final String TESTDATA_SMARTPHONE_URL = "testdata.smartphone.url";

    public static Smartphone withUrlFromProperty(){
        return new Smartphone(TestDataReader.getTestData(TESTDATA_SMARTPHONE_URL));
    }
}
