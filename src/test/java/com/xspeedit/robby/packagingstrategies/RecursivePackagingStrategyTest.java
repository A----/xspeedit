package com.xspeedit.robby.packagingstrategies;

import java.util.Arrays;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class RecursivePackagingStrategyTest
{
    private static final int DEFAULT_CAPACITY = 10;

    @Test
    public void testPackageBoxValid() {
        Collection<Integer> input = Arrays.asList(1, 6, 3, 8, 4);
        Collection<Collection<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(4, 6));
        expected.add(Arrays.asList(1, 8));
        expected.add(Arrays.asList(3));

        PackagingStrategy packager = new RecursivePackagingStrategy();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input, DEFAULT_CAPACITY);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test
    public void testPackageBoxExactSize() {
        Collection<Integer> input = Arrays.asList(1, 1, 6, 4, 3, 8, 2, 5);
        Collection<Collection<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(2, 8));
        expected.add(Arrays.asList(4, 6));
        expected.add(Arrays.asList(1, 1, 3, 5));

        PackagingStrategy packager = new RecursivePackagingStrategy();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input, DEFAULT_CAPACITY);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test
    public void testPackageBoxEmpty() {
        Collection<Integer> input = Arrays.asList();
        Collection<Collection<Integer>> expected = new ArrayList<>();

        PackagingStrategy packager = new RecursivePackagingStrategy();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input, DEFAULT_CAPACITY);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }
}
