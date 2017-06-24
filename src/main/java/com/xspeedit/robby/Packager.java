package com.xspeedit.robby;

import java.util.ArrayList;
import java.util.Collection;

import com.xspeedit.robby.packagingstrategies.PackagingStrategy;

/**
 * Place les entiers par "groupe" de 10.
 */
public class Packager
{
    private static final int CAPACITY = 10;

    private PackagingStrategy strategy;

    public Packager(PackagingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("A strategy must be specified");
        }
        this.strategy = strategy;
    }

    public Collection<Collection<Integer>> packageBoxes(Collection<Integer> input) {
        return this.strategy.packageBoxes(input, CAPACITY);
    }
}
