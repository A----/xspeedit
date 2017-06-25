package com.xspeedit.robby;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xspeedit.robby.testcategories.IntegrationTests;

@Category(IntegrationTests.class)
public class AppTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private static PrintStream DEFAULT_OUT;
    private static PrintStream DEFAULT_ERR;

    @BeforeClass
    public static void saveDefaultStreams() {
        DEFAULT_ERR = System.err;
        DEFAULT_OUT = System.out;
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(DEFAULT_OUT);
        System.setErr(DEFAULT_ERR);
    }

    @Test
    public void testMainValid() {
        int expectedCount = 15;
        int[] countPerWeight = new int[] { 0, 2, 1, 2, 1, 2, 2, 2, 2, 1 };

        App.main(new String[] { "163841689525773" });
        String actual = outContent.toString().trim();

        assertThat(actual.matches("^[1-9]+([/][1-9]+)*$"), is(true));
        
        Pattern countInts = Pattern.compile("[1-9]");
        Matcher matcher = countInts.matcher(actual);
        
        int count = 0;
        String group;
        while (matcher.find()) {
            count = count + 1;
            group = matcher.group();

            countPerWeight[Integer.parseInt(group)] = countPerWeight[Integer.parseInt(group)] - 1;
        }

        assertThat(count, is(expectedCount));
        
        for (int i = 0; i < countPerWeight.length; i++) {
            assertThat(countPerWeight[i] + " elements of weight " + i + " remaining while they should not.", countPerWeight[i], is(0));
        }
    }

    @Test
    public void testMainNoParameterSupplied() {
        String expected = "";

        App.main(new String[] { "" });
        String actual = outContent.toString().trim();

        assertThat(actual, is(expected));
    }
}
