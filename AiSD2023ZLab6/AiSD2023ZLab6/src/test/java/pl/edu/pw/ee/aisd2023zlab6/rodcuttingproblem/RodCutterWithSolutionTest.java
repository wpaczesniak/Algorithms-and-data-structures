package pl.edu.pw.ee.aisd2023zlab6.rodcuttingproblem;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RodCutterWithSolutionTest {

    @Test
    public void test(){
        RodCutterWithSolution rodCutter = new RodCutterWithSolution();
        Random random = new Random();
        int n = 8;
        int max = 100;
        int min = 1;
        int[] prices = {1, 5, 8, 9, 10, 19, 12, 10};
        RodCutterResult maxSum = rodCutter.cutRod(prices, n);
        long stop = System.nanoTime();
        System.out.println(maxSum);
    }

}
