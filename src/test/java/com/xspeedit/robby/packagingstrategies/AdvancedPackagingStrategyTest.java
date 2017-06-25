package com.xspeedit.robby.packagingstrategies;

import java.util.Arrays;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import com.xspeedit.robby.packagingstrategies.BasicPackagingStrategy;

import java.util.ArrayList;
import java.util.Collection;

public class AdvancedPackagingStrategyTest
{
    private static final int DEFAULT_CAPACITY = 10;

    @Test
    public void testPackageBoxValid() {
        Collection<Integer> input = Arrays.asList(1, 6, 3, 8, 4);
        Collection<Collection<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(8, 1));
        expected.add(Arrays.asList(6, 4));
        expected.add(Arrays.asList(3));

        PackagingStrategy packager = new AdvancedPackagingStrategy();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input, DEFAULT_CAPACITY);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test
    public void testPackageBoxExactSize() {
        Collection<Integer> input = Arrays.asList(1, 1, 6, 4, 3, 8, 2, 5);
        Collection<Collection<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(8, 2));
        expected.add(Arrays.asList(6, 4));
        expected.add(Arrays.asList(5, 3, 1, 1));

        PackagingStrategy packager = new AdvancedPackagingStrategy();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input, DEFAULT_CAPACITY);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }

    @Test
    public void testPackageBoxEmpty() {
        Collection<Integer> input = Arrays.asList();
        Collection<Collection<Integer>> expected = new ArrayList<>();

        PackagingStrategy packager = new AdvancedPackagingStrategy();
        Collection<Collection<Integer>> actual = packager.packageBoxes(input, DEFAULT_CAPACITY);

        assertThat(actual, notNullValue());
        assertThat(actual, is(expected));
    }
}
