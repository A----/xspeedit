package com.xspeedit.robby.io;

import java.util.Arrays;
import com.xspeedit.robby.io.Parser;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class ParserTest
{
    @Test
    public void testParseValid() {
        String input = "16384";
        Iterable<Integer> expected = Arrays.asList(1, 6, 3, 8, 4);

        Parser parser = new Parser();
        Iterable<Integer> actual = parser.parse(input);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalid() {
        String input = "4A6V";

        Parser parser = new Parser();
        parser.parse(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidZero() {
        String input = "163084";

        Parser parser = new Parser();
        parser.parse(input);
    }

    @Test
    public void testEmpty() {
        String input = "";
        Iterable<Integer> expected = Arrays.asList();

        Parser parser = new Parser();
        Iterable<Integer> actual = parser.parse(input);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }
}
