package com.xspeedit.robby.packagingstrategies;

import java.util.ArrayList;
import java.util.Collection;

public class BasicPackagingStrategy implements PackagingStrategy {
    public Collection<Collection<Integer>> packageBoxes(Collection<Integer> input, int boxCapacity) {
        Collection<Collection<Integer>> output = new ArrayList<>();

        int currentCapacity = 0;
        Collection<Integer> currentCollection = new ArrayList<>();
        for (Integer currentInteger : input) {
            if (currentCapacity + currentInteger > boxCapacity) {
                output.add(currentCollection);
                currentCapacity = 0;
                currentCollection = new ArrayList<>();
            }

            currentCollection.add(currentInteger);
            currentCapacity = currentCapacity + currentInteger;
        }

        if (currentCollection.size() > 0) {
            output.add(currentCollection);
        }

        return output;
    }
}