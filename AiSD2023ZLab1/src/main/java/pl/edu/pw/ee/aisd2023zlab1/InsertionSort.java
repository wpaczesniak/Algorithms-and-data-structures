package pl.edu.pw.ee.aisd2023zlab1;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;
import static java.util.Objects.isNull;
public class InsertionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        if (isNull(nums)) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }

        int i = 1;

        while (i < nums.length) {
            double elem = nums[i];
            int j = i - 1;

            while (j > -1 && nums[j] > elem) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = elem;
            i++;
        }
    }

}
