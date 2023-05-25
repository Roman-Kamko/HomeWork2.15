package edu.skypro.sorting.impl;

import edu.skypro.sorting.Sorting;

public class InsertSort implements Sorting {
    private long iteration;
    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int tmp = nums[i];

            while (index > 0 && nums[index - 1] >= tmp) {
                nums[index] = nums[index - 1];
                index--;

                iteration++;
            }

            nums[index] = tmp;

            iteration++;
        }
        return nums;
    }

    @Override
    public long getIteration() {
        return iteration;
    }
}
