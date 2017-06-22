package com.xspeedit.robby.io;

import java.util.ArrayList;
import java.util.Arrays;
import com.xspeedit.robby.io.Parser;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class FormatterTest
{
    @Test
    public void testFormatValid() {
        ArrayList<Iterable<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 6, 3));
        input.add(Arrays.asList(8));
        input.add(Arrays.asList(4));
        String expected = "163/8/4";

        Formatter formatter = new Formatter();
        String actual = formatter.format(input);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test
    public void testEmpty() {
        ArrayList<Iterable<Integer>> input = new ArrayList<>();
        String expected = "";

        Formatter formatter = new Formatter();
        String actual = formatter.format(input);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }
}
