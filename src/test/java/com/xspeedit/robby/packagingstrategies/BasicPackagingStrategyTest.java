package com.xspeedit.robby.packagingstrategies;

import java.util.Arrays;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import com.xspeedit.robby.packagingstrategies.BasicPackagingStrategy;

import java.util.ArrayList;
import java.util.Collection;

public class BasicPackagingStrategyTest
{
    private static final int DEFAULT_CAPACITY = 10;

    @Test
    public void testPackageBoxValid() {
        Collection<Integer> input = Arrays.asList(1, 6, 3, 8, 4);
        Collection<Collection<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 6, 3));
        expected.add(Arrays.asList(8));
        expected.add(Arrays.asList(4));

        PackagingStrategy packager = new BasicPackagingStrategy();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input, DEFAULT_CAPACITY);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test
    public void testPackageBoxExactSize() {
        Collection<Integer> input = Arrays.asList(1, 6, 3, 8, 2);
        Collection<Collection<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 6, 3));
        expected.add(Arrays.asList(8, 2));

        PackagingStrategy packager = new BasicPackagingStrategy();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input, DEFAULT_CAPACITY);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test
    public void testPackageBoxEmpty() {
        Collection<Integer> input = Arrays.asList();
        Collection<Collection<Integer>> expected = new ArrayList<>();

        PackagingStrategy packager = new BasicPackagingStrategy();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input, DEFAULT_CAPACITY);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }
}
