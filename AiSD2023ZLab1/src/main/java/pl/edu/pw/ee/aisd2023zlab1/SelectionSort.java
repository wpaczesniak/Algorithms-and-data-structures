package pl.edu.pw.ee.aisd2023zlab1;

import static java.util.Objects.isNull;
import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

public class SelectionSort implements Sorting {

     @Override
    public void sort(double[] nums) {
        if (isNull(nums)) {
            throw new IllegalArgumentException( "Input args (nums) cannot be null!");
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minValId = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minValId]) {
                    minValId = j;
                }
            }

            double elem = nums[i];
            nums[i] = nums[minValId];
            nums[minValId] = elem;
        }
    }
}

            
