package com.xspeedit.robby.packagingstrategies;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Algorithme basique.
 * Conditionne les éléments séquentiellement, tant que la boîte n'a pas dépassé sa capacité.
 * Dans le cas contraire, prend une nouvelle boîte et ainsi de suite.
 */
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