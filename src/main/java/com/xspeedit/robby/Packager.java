package com.xspeedit.robby;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Place les entiers par "groupe" de 10.
 */
public class Packager
{
    private static final int CAPACITY = 10;

    public Collection<Collection<Integer>> packageBoxes(Collection<Integer> input) {
        Collection<Collection<Integer>> output = new ArrayList<>();

        int currentCapacity = 0;
        Collection<Integer> currentCollection = new ArrayList<>();
        for (Integer currentInteger : input) {
            if (currentCapacity + currentInteger > CAPACITY) {
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
