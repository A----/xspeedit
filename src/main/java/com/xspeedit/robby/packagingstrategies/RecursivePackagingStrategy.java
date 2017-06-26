package com.xspeedit.robby.packagingstrategies;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Algorithme récursif.
 * Fixer la capacité voulue à la capacité de la boîte.
 * Trouver (récursivement) une combinaison d'éléments dont la somme fasse la capacité voulue.
 * Retirer ces éléments de la liste.
 * Répéter tant qu'une combinaison existe.
 * Décrémenter la capacité voulue.
 * Répéter tant que la capacité n'est pas nulle.
 */
public class RecursivePackagingStrategy implements PackagingStrategy {
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


        int targetCapacity = boxCapacity;
        Collection<Integer> currentCollection = new ArrayList<>();
        while (targetCapacity > 0) {
            while (findCombination(currentCollection, countPerWeight, 0, targetCapacity)) {
                for (Integer i : currentCollection) {
                    countPerWeight[i] = countPerWeight[i] - 1;
                }
                output.add(currentCollection);
                currentCollection = new ArrayList<>();
            }
            targetCapacity = targetCapacity - 1;
        }

        return output;
    }

    private boolean findCombination(Collection<Integer> currentCollection, int[] availableItems, int currentCapacity, int targetCapacity) {
        int remainingCapacity = targetCapacity - currentCapacity;

        int i;
        if (remainingCapacity == 0) {
            return true;
        }
        else if (remainingCapacity > MAX_WEIGHT) {
            i = MAX_WEIGHT;
        }
        else {
            i = remainingCapacity;
        }

        while (i >= MIN_WEIGHT) {
            if (availableItems[i] > 0) {
                    int[] clonedAvailableItems = availableItems.clone();
                    clonedAvailableItems[i] = clonedAvailableItems[i] - 1;
                    if (findCombination(currentCollection, clonedAvailableItems, currentCapacity + i, targetCapacity)) {
                        currentCollection.add(i);
                        return true;
                    }
            }

            i = i - 1;
        }
        
        return false;
    }
}