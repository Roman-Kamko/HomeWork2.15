package edu.skypro.sorting.impl;

import edu.skypro.sorting.Sorting;

public class SelectionSort implements Sorting {
    private long iteration;
    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minValue = nums[i];
            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < minValue) {
                    minValue = nums[j];
                    minIndex = j;
                }
                iteration++;
            }

            if (minIndex != i) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = tmp;
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
