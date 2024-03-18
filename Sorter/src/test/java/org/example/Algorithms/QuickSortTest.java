package org.example.Algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    private QuickSort sorter;
    private Random rand;

    @BeforeEach
    public void setUp() {
        sorter = new QuickSort();
        rand = new Random();
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
    public void shouldSortReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void shouldSortArrayWithDuplicates() {
        int[] arr = {5, 5, 5, 5, 5};
        sorter.sort(arr);
        assertArrayEquals(arr, new int[]{5, 5, 5, 5, 5});
    }



    @Test
    // @Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void shouldSortLargeArray() {
        int[] arr = new int[10000];
        Arrays.setAll(arr, i -> rand.nextInt(10000));
        sorter.sort(arr);
        assertTrue(isArraySorted(arr));
    }

    @Test
    public void shouldSortBestCaseArray() {
        int[] arr = {1, 2, 4,3,6,7,10,9,8,5};
        long startTime = System.nanoTime();
        sorter.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("Elapsed time for best case: " + (endTime - startTime) + " nanoseconds");
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5,6,7,8,9,10});
    }

    @Test
    public void shouldSortAverageCaseArray() {
        int[] arr = new int[10];
        Arrays.setAll(arr, i -> rand.nextInt(100));
        long startTime = System.nanoTime();
        sorter.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("Elapsed time for average case: " + (endTime - startTime) + " nanoseconds");
        assertTrue(isArraySorted(arr));
    }

    @Test
    public void shouldSortWorstCaseArray() {
        int[] arr = new int[10];
        Arrays.setAll(arr, i -> i);
        long startTime = System.nanoTime();
        sorter.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("Elapsed time for worst case: " + (endTime - startTime) + " nanoseconds");
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