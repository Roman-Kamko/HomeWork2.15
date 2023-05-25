package edu.skypro.sorting;

import edu.skypro.sorting.impl.BubbleSort;
import edu.skypro.sorting.impl.SelectionSort;
import edu.skypro.sorting.impl.InsertSort;

import java.util.Arrays;
import java.util.Random;

public class Runner {
    static Random random = new Random();
    static Sorting bubbleSort = new BubbleSort();
    static Sorting insertSort = new InsertSort();
    static Sorting selectionSort = new SelectionSort();
    public static void main(String[] args) {
        int[] numsForBubble = generateArray(100_000);
        long bubbleStart = System.currentTimeMillis();
        bubbleSort.sort(numsForBubble);
        long bubbleFinish = System.currentTimeMillis();
        long bubbleElapsedTime = bubbleFinish - bubbleStart;
        System.out.printf("Время пузырьком: %,d мс; итераций: %,d%n", bubbleElapsedTime, bubbleSort.getIteration());

        int[] numsForInsert = generateArray(100_000);
        long insertStart = System.currentTimeMillis();
        insertSort.sort(numsForInsert);
        long insertFinish = System.currentTimeMillis();
        long insertElapsedTime = insertFinish - insertStart;
        System.out.printf("Время вставкой: %,d мс; итераций: %,d%n", insertElapsedTime, insertSort.getIteration());

        int[] numsForSelection = generateArray(100_000);
        long selectionStart = System.currentTimeMillis();
        selectionSort.sort(numsForSelection);
        long selectionFinish = System.currentTimeMillis();
        long selectionElapsedTime = selectionFinish - selectionStart;
        System.out.printf("Время выбором: %,d мс; итераций: %,d%n", selectionElapsedTime, selectionSort.getIteration());

        int[] numsForDefault = generateArray(100_000);
        long defaultStart = System.currentTimeMillis();
        Arrays.sort(numsForDefault);
        long defaultFinish = System.currentTimeMillis();
        long defaultElapsedTime = defaultFinish - defaultStart;
        System.out.printf("Время дефолтной сортировки: %,d мс;", defaultElapsedTime);
    }

    static int[] generateArray(int len) {
        int[] nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100_001);
        }
        return nums;
    }
}
