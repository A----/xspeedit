package com.xspeedit.robby.packagingstrategies;

import java.util.Collection;

public interface PackagingStrategy {
    Collection<Collection<Integer>> packageBoxes(Collection<Integer> input, int boxCapacity);
}