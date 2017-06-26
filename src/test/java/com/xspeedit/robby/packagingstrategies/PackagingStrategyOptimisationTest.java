package com.xspeedit.robby.packagingstrategies;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.xspeedit.robby.packagingstrategies.BasicPackagingStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.xspeedit.robby.testcategories.OptimisationTests;

@RunWith(Parameterized.class)
@Category(OptimisationTests.class)
public class PackagingStrategyOptimisationTest
{

    @Parameters
    public static Collection<PackagingStrategy> data() {
        return Arrays.asList(new BasicPackagingStrategy(), new AdvancedPackagingStrategy(), new RecursivePackagingStrategy());
    }

    private final PackagingStrategy strategy;

    public PackagingStrategyOptimisationTest(PackagingStrategy strategy) {
        this.strategy = strategy;
    }

    private static final int DEFAULT_CAPACITY = 10;

    private static final Map<String, Collection<Collection<Integer>>> TEST_SETS = new HashMap<>();
    private static final Random RAND = new Random();

    private static Collection<Integer> generateInput(int length) {
        Collection<Integer> input = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            input.add(RAND.nextInt(9) + 1);
        }

        return input;
    }

    @BeforeClass
    public static void generateTestSets() {
        int count = 1000;
        String testSetName;
        for (int size : Arrays.asList(10)) {
            testSetName = "Test set of " + size + " elements";

            System.out.println("Generating test set: " + testSetName);

            Collection<Collection<Integer>> inputs = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                inputs.add(generateInput(size));
            }
            TEST_SETS.put(testSetName, inputs);

            System.out.println("Test set generated.");
        }
    }

    static class ResultTestSet {
        private static final BruteForcePackagingStrategy BRUTE_FORCE_PACKAGING_STRATEGY = new BruteForcePackagingStrategy();
        private static final Map<Collection<Integer>, Collection<Collection<Integer>>> BRUTE_FORCE_OUTPUTS = new HashMap<>();

        private String testSetName;
        private PackagingStrategy strategy;

        private int subOptimalCount = 0;
        private int count = 0;
        private int boxCount = 0;
        private int minBoxCount = 0;

        private long executionTime = 0;

        private long startTime;
        private long endTime;

        public ResultTestSet(PackagingStrategy strategy, String testSetName) {
            this.testSetName = testSetName;
            this.strategy = strategy;
        }

        public void add(Collection<Integer> input) {
            startTime = System.nanoTime();
            Collection<Collection<Integer>> output = strategy.packageBoxes(input, DEFAULT_CAPACITY);
            endTime = System.nanoTime();

            Collection<Collection<Integer>> bruteforceOutput;
            if (BRUTE_FORCE_OUTPUTS.containsKey(input)) {
                bruteforceOutput = BRUTE_FORCE_OUTPUTS.get(input);
            }
            else {
                bruteforceOutput = BRUTE_FORCE_PACKAGING_STRATEGY.packageBoxes(input, DEFAULT_CAPACITY);
                BRUTE_FORCE_OUTPUTS.put(input, bruteforceOutput);
            }

            executionTime = executionTime + (endTime - startTime);

            count = count + 1;
            boxCount = boxCount + output.size();
            minBoxCount = minBoxCount + bruteforceOutput.size();

            if (bruteforceOutput.size() < output.size()) {
                subOptimalCount = subOptimalCount + 1;
                /*System.out.println(input);
                System.out.println(output);
                System.out.println(bruteforceOutput);
                System.out.println("---");*/
            }
            else if (bruteforceOutput.size() > output.size()) {
                throw new IllegalStateException("Result is less than the brute-force one. Input: " + input +
                    ", Output: " + output + ", Bruteforce: " + bruteforceOutput);
            }
        }

        public String toString() {
            return this.strategy.getClass().getName() + " (" + this.testSetName + ")" + System.lineSeparator() +
                "\t" + count + " runs for a total of " + executionTime / 1000. +
                    "ms (" + (double) executionTime / 1000 / count + "ms per run avg)" + System.lineSeparator() +
                "\t" + subOptimalCount + " runs were suboptimized (" + (100. * subOptimalCount / count) + "%)" + System.lineSeparator() +
                "\t" + boxCount + " boxes shipped, minimum was " + minBoxCount + " (" + (100. * boxCount / minBoxCount) + "%)" +  System.lineSeparator();
        }
    }

    @Test
    public void testOptimisation() {
        ResultTestSet results;
        for (Map.Entry<String, Collection<Collection<Integer>>> testSet: TEST_SETS.entrySet()) {
            results = new ResultTestSet(this.strategy, testSet.getKey());
            for (Collection<Integer> input: testSet.getValue()) {
                results.add(input);
            }
            System.out.println(results);
        }
    }

}
