package com.jsystems.testautomation.jupiter;


import com.jsystems.testautomation.GamePlay;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.core.Is.is;

@DisplayName("Jupiter test class")
public class JUpiterTest extends ConfigJUpiter {

    String testowyString = "firstTest";

    @Test

    @DisplayName("Test for strings")
    public void firstTest() {

        assertTrue(true);
        assertTrue(testowyString.equals("firstTest"));
        assertTrue( 5 == 2 + 3);
        assertFalse( 5 == 1 + 3);
        assertThat(testowyString, is("firstTest"));
        assertSame(testowyString, "firstTest");
        assertThat(testowyString, containsString("first"));

        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
    }

    @Nested
    @DisplayName("Nested class")
    public class JupiterNestedClass{
        @Test
        @DisplayName("Test for nested strings")
        public void firstNestedTest() {

            assertTrue(true);
            assertTrue(testowyString.equals("firstTest"));
            assertTrue( 5 == 2 + 3);
            assertFalse( 5 == 1 + 3);
            assertThat(testowyString, is("firstTest"));
            assertSame(testowyString, "firstTest");
            assertThat(testowyString, containsString("first"));

            assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
        }
        @Nested
        @DisplayName("Nested Nested class")
        public class JupiterNestedNestedClass{

            @Test
            @DisplayName("Test for nested nested strings")
            public void firstSecondTest() {

                assertTrue(true);
                assertTrue(testowyString.equals("firstTest"));
                assertTrue( 5 == 2 + 3);
                assertFalse( 5 == 1 + 3);
                assertThat(testowyString, is("firstTest"));
                assertSame(testowyString, "firstTest");
                assertThat(testowyString, containsString("first"));

                assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
            }
        }
    }

    @Test
    @Tag("All")
    @DisplayName("Exception test")
    public void exceptionTest(){
        GamePlay gameplayer = new GamePlay();
        assertThrows(IllegalArgumentException.class, ()->gameplayer.play(0));
    }


}
