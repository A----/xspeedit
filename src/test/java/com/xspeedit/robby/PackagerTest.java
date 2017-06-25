package com.xspeedit.robby;

import org.junit.Test;

public class PackagerTest
{
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalid() {
        new Packager(null);
    }
}
