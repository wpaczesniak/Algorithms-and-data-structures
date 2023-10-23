package pl.edu.pw.ee.aisd2023zlab1.utils;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

public abstract class GeneralSortTest {

    protected Sorting sorter;
    protected static final double EPS = 0;

    public GeneralSortTest(Sorting sorter) {
        this.sorter = sorter;
    }

    @Test
    public void should_ThrowException_WhenInputIsNull() {
        // given
        double[] nums = null;

        // when
        Throwable exceptionCaught = catchThrowable(() -> {
            sorter.sort(nums);
        });

        // then
        String message = "Input args (nums) cannot be null!";

        assertThat(exceptionCaught).isInstanceOf(RuntimeException.class).hasMessage(message);
    }

    @Test
    public void should_ReturnEmptyArray_WhenInputIsEmpty() {
        // given
        double[] nums = {};

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isEmpty();
    }

    @Test
    public void should_CorrectlyAscendingSort_WhenInputIsRandomAndHuge() {
        // given
        int size = 10_000;
        double[] nums = createRandomData(size);
        double[] numsCopy = nums.clone();

        // when
        sorter.sort(nums);

        // then
        assertThat(nums).isSorted().containsExactlyInAnyOrder(numsCopy);

    }

    private double[] createRandomData(int size) {
        assert size >= 0;

        double[] nums = new double[size];

        long eliteSeed = 31337;
        Random rand = new Random(eliteSeed);

        for (int i = 0; i < size; i++) {
            nums[i] = rand.nextDouble();
        }

        return nums;
    }

    @Test
    public void should_CorrectlySort_WhenInputIsOneElem() {
        // given
        double[] nums = {34};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {34};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputAreTwoElemPessimistic() {
        // given
        double[] nums = {34, 1};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {1, 34};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputAreTwoElemOptimistic() {
        // given
        double[] nums = {1, 34};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {1, 34};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputTheSameTwoElem() {
        // given
        double[] nums = {1, 1};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {1, 1};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputTreeElem() {
        // given
        double[] nums = {34, 1, 4};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {1, 4, 34};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputTreeElemPessimistic() {
        // given
        double[] nums = {34, 4, 1};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {1, 4, 34};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputTreeElemOptymisticData() {
        // given
        double[] nums = {1, 4, 34};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {1, 4, 34};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputTreeElemWhereAreTheSameTwoElem() {
        // given
        double[] nums = {4, 4, 34};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {4, 4, 34};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputTreeElemWhereAreTheSameThreeElem() {
        // given
        double[] nums = {4, 4, 4};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {4, 4, 4};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputAreSixElems() {
        // given
        double[] nums = {3, -9, 2, 6, 1, 4};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {-9, 1, 2, 3, 4, 6};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputAreSixElemsAndTwoFirstElemNotSort() {
        // given
        double[] nums = {1, -9, 2, 3, 4, 6};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {-9, 1, 2, 3, 4, 6};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputAreSixElemsAndTwoLastElemNotSort() {
        // given
        double[] nums = {-9, 1, 2, 3, 6, 4};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {-9, 1, 2, 3, 4, 6};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputAreFiveElems() {
        // given
        double[] nums = {3, -9, 2, 6, 1};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {-9, 1, 2, 3, 6};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputAreFiveElemsAndTwoFirstElemNotSort() {
        // given
        double[] nums = {1, -9, 2, 3, 4};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {-9, 1, 2, 3, 4};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputAreFiveElemsAndTwoLastElemNotSort() {
        // given
        double[] nums = {-9, 1, 2, 6, 4};

        // when
        sorter.sort(nums);

        // then
        double[] expecteds = {-9, 1, 2, 4, 6};
        assertArrayEquals(expecteds, nums, 0);
    }

    @Test
    public void should_CorrectlySort_WhenInputAreDoubleElem() {
        // given
        double[] nums = {-4.5, 0.421342, 0.37, -2.3, -0.743, 0.4, 15.42, 8323.9};

        // when
        sorter.sort(nums);

        // then
        double[] expected = {-4.5, -2.3, -0.743, 0.37, 0.4, 0.421342, 15.42, 8323.9};
        assertArrayEquals(expected, nums, EPS);
    }


}
