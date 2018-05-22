package com.jsystems.testautomation.junit;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;


public class JunitTest extends ConfigJUnit {

    String testowyString = "firstTest";
    @Before
    public void setUp(){
        System.out.println("====================================== @BeforeTest2 ==============================");
    }

    @After
    public void tearDown(){
        System.out.println("====================================== @AfterTest2 ==============================");
    }

    @Test
    public void firstTest() {

        assertTrue(true);
        assertTrue(testowyString.equals("firstTest"));
        assertTrue("message from future", 5 == 2 + 3);
        assertFalse("message from future", 5 == 1 + 3);
        assertThat(testowyString, is("firstTest"));
        assertSame(testowyString, "firstTest");
        assertThat(testowyString, containsString("first"));

        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
    }

    @Test
    public void arraysTest() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list1a = Arrays.asList(1, 2, 3, 4, 5);
        List<String> list2 = Arrays.asList("Ewa", "Ada,", "Jan", "Adam", "Tomek");
        List<String> list2a = Arrays.asList("Ewa", "Ada,", "Jan");
        List<String> list3 = new ArrayList<>();

        assertArrayEquals(list1.toArray(), list1a.toArray());
        assertThat(list2, hasSize(5));
        assertThat(list1, contains(1, 2, 3, 4, 5));
        assertThat(list3, IsEmptyCollection.empty());
        assertThat(list2, not(IsEmptyCollection.empty()));
        assertTrue(list2.containsAll(list2a));
        assertThat(list1.size(), is(5));

    }

    @Test
    public void jcabiTest() {
        assertThat(testowyString, matchesPattern("^first.*"));
        assertThat("123456789", matchesPattern("^[0-9]+"));
    }
}
