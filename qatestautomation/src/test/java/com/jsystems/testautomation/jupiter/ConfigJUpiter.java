package com.jsystems.testautomation.jupiter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ConfigJUpiter {

    @BeforeAll

    public static void beforeAllTest() {
        System.out.println("====================================== @BeforeAllTests ==============================");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("====================================== @AfterTests ==============================");
    }

    @BeforeEach
    public void setUpEach(){
        System.out.println("====================================== @BeforeEachTest ==============================");
    }

    @AfterEach
    public void tearDownEach(){
        System.out.println("====================================== @AfterEachTest ==============================");
    }

}
