package com.xspeedit.robby;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.xspeedit.robby.testcategories.IntegrationTests;

@Category(IntegrationTests.class)
public class AppTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testMainValid() {
        String expected = "163/8/41/6/8/9/52/5/7/73";

        App.main(new String[] { "163841689525773" });
        String actual = outContent.toString().trim();

        assertThat(actual, is(expected));
    }

    @Test
    public void testMainNoParameterSupplied() {
        String expected = "";

        App.main(new String[] { "" });
        String actual = outContent.toString().trim();

        assertThat(actual, is(expected));
    }
}
