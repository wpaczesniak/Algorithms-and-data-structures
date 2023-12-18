package pl.edu.pw.ee.aisd2023zlab6.rodcuttingproblem;

import java.util.Arrays;

public class RodCutterResult {

    private int[] maxSumResults;
    private int[] solutions;

    public RodCutterResult(int[] maxSumResults, int[] solutions) {
        this.maxSumResults = maxSumResults;
        this.solutions = solutions;
    }

    public int[] getMaxSumResults() {
        return maxSumResults;
    }

    public int[] getSolutions() {
        return solutions;
    }

    @Override
    public String toString() {
        return   "Solutions=" + Arrays.toString(solutions) +  " maxSumResults=" + Arrays.toString(maxSumResults);
    }
}
