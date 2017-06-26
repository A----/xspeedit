package com.xspeedit.robby.packagingstrategies;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Algorithme avancée.
 * Compte les éléments par masse.
 * Tant qu'il reste des éléments, prendre une nouvelle boîte.
 * Tant qu'il reste de la place, placer l'élément le plus lourd pouvant rentrer.
 * Répéter.
 */
public class AdvancedPackagingStrategy implements PackagingStrategy {
    private final static int MAX_WEIGHT = 9;
    private final static int MIN_WEIGHT = 1;

    public Collection<Collection<Integer>> packageBoxes(Collection<Integer> input, int boxCapacity) {
        if (boxCapacity < MAX_WEIGHT) {
            throw new IllegalArgumentException("Items can weight more than the box capacity");
        }

        Collection<Collection<Integer>> output = new ArrayList<>();

        int[] countPerWeight = new int[MAX_WEIGHT + 1];
        for (Integer currentInteger : input) {
            countPerWeight[currentInteger] = countPerWeight[currentInteger] + 1;
        }

        int currentCapacity = 0;
        Collection<Integer> currentCollection = new ArrayList<>();
        int j;
        for (int i = MAX_WEIGHT; i >= MIN_WEIGHT; i--) {
            while (countPerWeight[i] > 0) {
                countPerWeight[i] = countPerWeight[i] - 1;
                currentCollection.add(i);
                currentCapacity = currentCapacity + i;
                j = boxCapacity - currentCapacity;

                while (j >= MIN_WEIGHT) {
                    if (countPerWeight[j] > 0) {
                        countPerWeight[j] = countPerWeight[j] - 1;
                        currentCollection.add(j);
                        currentCapacity = currentCapacity + j;
                        j = boxCapacity - currentCapacity;
                    }
                    else {
                        j = j - 1;
                    }
                }

                output.add(currentCollection);
                currentCollection = new ArrayList<>();
                currentCapacity = 0;
            }
        }

        return output;
    }
}