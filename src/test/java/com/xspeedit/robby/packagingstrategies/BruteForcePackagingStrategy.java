package com.xspeedit.robby.packagingstrategies;

import java.util.List;
import java.util.Collection;
import java.util.Collections;

import com.google.common.collect.Collections2;

/**
 * Remplissage des boîtes par force brute.
 * Version sous-optimisée d'un brute-force !
 */
public class BruteForcePackagingStrategy implements PackagingStrategy {

    public Collection<Collection<Integer>> packageBoxes(Collection<Integer> input, int boxCapacity) {
        PackagingStrategy strategy = new BasicPackagingStrategy();

        Collection<List<Integer>> permutations = Collections2.orderedPermutations(input);

        Collection<Collection<Integer>> minOutput = Collections.emptyList();
        Collection<Collection<Integer>> currentOutput;
        int minBoxCount = -1;
        for (Collection<Integer> permutation: permutations) {
            currentOutput = strategy.packageBoxes(permutation, boxCapacity);
            if (minBoxCount == -1 || minBoxCount > currentOutput.size()) {
                minOutput = currentOutput;
                minBoxCount = minOutput.size();
            }
        }

        return minOutput;
    }
}