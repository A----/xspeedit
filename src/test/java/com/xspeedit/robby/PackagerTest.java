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
        Collection<Integer> input = Arrays.asList(1, 6, 3, 8, 4);
        Collection<Collection<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 6, 3));
        expected.add(Arrays.asList(8));
        expected.add(Arrays.asList(4));

        Packager packager = new Packager();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test
    public void testPackageBoxExactSize() {
        Collection<Integer> input = Arrays.asList(1, 6, 3, 8, 2);
        Collection<Collection<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 6, 3));
        expected.add(Arrays.asList(8, 2));

        Packager packager = new Packager();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test
    public void testPackageBoxEmpty() {
        Collection<Integer> input = Arrays.asList();
        Collection<Collection<Integer>> expected = new ArrayList<>();

        Packager packager = new Packager();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }
}
