package org.example.Algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InsertionSortTest {
    private InsertionSort sorter;

    @BeforeEach
    public void setUp() {
        sorter = new InsertionSort();
    }

    @Test
    public void shouldSortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void shouldSortReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void shouldSortNegativeElementsArray() {
        int[] arr = {-5, 4, 3, -2, 10, -19, -21, 0};
        sorter.sort(arr);
        assertArrayEquals(arr, new int[]{-21, -19, -5, -2, 0, 3, 4, 10});
    }

    @Test
    public void shouldSortRandomArray() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        sorter.sort(arr);
        assertArrayEquals(arr, new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9});
    }

    @Test
    public void shouldSortEmptyArray() {
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(arr, new int[]{});
    }

    @Test
    public void shouldSortSingleElementArray() {
        int[] arr = {1};
        sorter.sort(arr);
        assertArrayEquals(arr, new int[]{1});
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
    public void shouldSortArrayWithDuplicateElements() {
        int[] arr = {5, 5, 5, 5, 5};
        sorter.sort(arr);
        assertArrayEquals(arr, new int[]{5, 5, 5, 5, 5});
    }

//    @Test
//    @Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
//    public void shouldSortLargeArrayInLessThan5Seconds() {
//        int size = 1000000;
//        sorter.setAreStepsSaved(false);
//        int[] arr = new int[size];
//        Random rand = new Random();
//        Arrays.setAll(arr, i -> rand.nextInt(size));
//        long start = System.currentTimeMillis();
//        sorter.sort(arr);
//        long end = System.currentTimeMillis();
//        System.out.println("Time taken for sorting large array: " + (end - start) + "ms");
//        assertTrue(isArraySorted(arr));
//    }

    @Test
    public void shouldSortLargeArray() {
        int size = 10000;
        sorter.setAreStepsSaved(false);
        int[] arr = new int[size];
        Random rand = new Random();
        Arrays.setAll(arr, i -> rand.nextInt(size));
        long start = System.currentTimeMillis();
        sorter.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Time taken for sorting large array: " + (end - start) + "ms");
        assertTrue(isArraySorted(arr));
    }

    private boolean isArraySorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}