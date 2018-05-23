package com.jsystems.testautomation.jupiter;

import com.jsystems.testautomation.junit.ConfigJUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parametrized test with JUpiter")

public class ParametrizedJUpiterTest extends ConfigJUpiter {



    @ParameterizedTest
    @CsvSource({"Hello,5","HelloJUnit 5, 15","'Hello, JUnit 5!', 25"})
    public void parametrizedFirstTest(String text, int number){
        assertTrue(text.contains("Hello"));
        assertTrue(number % 5 == 0);
    }

    @ParameterizedTest
    @DisplayName("Prostszy test")
    @CsvSource({"Hello","FirstHello","HelloWorld"})
    public void parametrizedSimplerTest(String param){
        assertTrue(param.contains("Hello"));
    }


    @ParameterizedTest
    @DisplayName("Check if contains hello for Int test")
    @CsvSource({"15","20","25"})
    public void parametrizedSecondSimplerTest(int param){
        assertTrue(param % 5 == 0);
    }

    @ParameterizedTest
    @DisplayName("Parameters from file tests")
    @CsvFileSource(resources = "/plik.csv")
    @Tag("All")
    public void parametrizedFromFileTest(String name, Integer age){
        assertTrue(name.contains("Hello"));
        assertTrue(age % 5 == 0);
        assertTrue(age instanceof  Integer);
    }

    @ParameterizedTest
    @DisplayName("Parameters from file tests")
    @ValueSource(ints = {5,15,25})
    public void parametrizedValueSourceTest(int age){
        //assertTrue(name.contains("Hello"));
        assertTrue(age % 5 == 0);
       // assertTrue(name instanceof  String);
    }
}
