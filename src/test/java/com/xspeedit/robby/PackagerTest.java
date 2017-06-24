package com.xspeedit.robby;

import java.util.Arrays;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import com.xspeedit.robby.packagingstrategies.BasicPackagingStrategy;

import java.util.ArrayList;
import java.util.Collection;

public class PackagerTest
{
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalid() {
        new Packager(null);
    }
}
