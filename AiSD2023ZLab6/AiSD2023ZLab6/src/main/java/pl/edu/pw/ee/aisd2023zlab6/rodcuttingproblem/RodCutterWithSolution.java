package pl.edu.pw.ee.aisd2023zlab6.rodcuttingproblem;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Objects.isNull;

public class RodCutterWithSolution {
    public RodCutterResult cutRod(int[] prices, int rodLength) {
        validateInput(prices, rodLength);

        int[] results = new int[rodLength + 1];
        int[] solutions = new int[rodLength + 1];

        for (int i = 1; i <= rodLength; i++) {
            int result = Integer.MIN_VALUE;
            int cutter = 0;

            for (int j = 1; j <= i; j++) {
                if (result < prices[j - 1] + results[i - j]) {
                    result = prices[j - 1] + results[i - j];
                    cutter = j;
                }
            }

            results[i] = result;
            solutions[i] = cutter;
        }
        ArrayList<Integer> cuts = new ArrayList<>();
        int lenght = rodLength;
        while (lenght > 0) {
            int cut = solutions[lenght];
            cuts.add(cut);
            lenght -= cut;
        }
        int[] arr = cuts.stream().mapToInt(i -> i).toArray();
        return new RodCutterResult(results, arr);
    }


    private void validateInput(int[] prices, int rodLength) {
        if (isNull(prices)) {
            throw new IllegalArgumentException("Price array cannot be null!");
        }

        if (prices.length < rodLength) {
            throw new IllegalArgumentException("The size of the price array cannot be smaller than the length of the rod!");
        }

        if (rodLength < 0) {
            throw new IllegalArgumentException("Rod length cannot be negative!");
        }


    }
}