package com.jsystems.testautomation.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class ConfigJUnit {


    @BeforeClass

    public static void beforeClass() {
        System.out.println("====================================== @BeforeClass ==============================");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("====================================== @AfterClass ==============================");
    }

    @Before
    public void setUp(){
        System.out.println("====================================== @BeforeTest ==============================");
    }

    @After
    public void tearDown(){
        System.out.println("====================================== @AfterTest ==============================");
    }
}
