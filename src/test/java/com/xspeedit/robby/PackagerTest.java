package com.xspeedit.robby;

import java.util.Arrays;
import com.xspeedit.robby.io.Parser;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;

public class PackagerTest
{
    @Test
    public void testPackageBoxValid() {
        Iterable<Integer> input = Arrays.asList(1, 6, 3, 8, 4);
        ArrayList<Iterable<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 6, 3));
        expected.add(Arrays.asList(8));
        expected.add(Arrays.asList(4));

        Packager packager = new Packager();
        Iterable<Iterable<Integer>> actual = packager.packageBoxes(input);

        assertThat(actual, notNullValue());
        //assertThat(actual, has(expected));
    }

    @Test
    public void testEmpty() {
        Iterable<Integer> input = Arrays.asList();
        Collection<Iterable<Integer>> expected = new ArrayList<>();

        Packager packager = new Packager();
        Iterable<Iterable<Integer>> actual = packager.packageBoxes(input);

        assertThat(actual, notNullValue());
        //assertThat(actual, is(expected));
    }
}
