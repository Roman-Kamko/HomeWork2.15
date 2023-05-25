package edu.skypro.sorting.impl;

import edu.skypro.sorting.Sorting;

public class BubbleSort implements Sorting {
    private long iteration;
    @Override
    public int[] sort(int[] nums) {

        for (int i = nums.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
                iteration++;
            }

            iteration++;
        }
        return nums;
    }

    @Override
    public long getIteration() {
        return iteration;
    }
}
