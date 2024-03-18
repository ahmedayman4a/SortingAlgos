package org.example.Algorithms;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CountSortTest {

    private final CountSort countSort = new CountSort();

    @Test
    public void shouldSortEmptyArray() {
        int[] arr = new int[0];
        countSort.sort(arr);
        assertArrayEquals(arr, new int[0]);
    }

    @Test
    public void shouldSortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        countSort.sort(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void shouldSortReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        countSort.sort(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void shouldSortArrayWithDuplicates() {
        int[] arr = {2, 2, 1, 1, 3};
        countSort.sort(arr);
        assertArrayEquals(arr, new int[]{1, 1, 2, 2, 3});
    }

    @Test
    public void shouldSortArrayWithAllElementsSame() {
        int[] arr = new int[100];
        Arrays.fill(arr, 50);
        int[] unsorted = arr.clone();
        long startTime = System.nanoTime();
        countSort.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("Elapsed time for worst case: " + (endTime - startTime) + " nanoseconds");

        assertArrayEquals(unsorted, arr);
    }

    @Test
    public void shouldSortAlreadySortedArrayInBestCase() {
        int[] arr = new int[100];
        Arrays.setAll(arr, i -> i);
        int[] sorted = arr.clone();
        long startTime = System.nanoTime();
        countSort.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("Elapsed time for best case: " + (endTime - startTime) + " nanoseconds");
        assertArrayEquals(arr, sorted);
    }

    @Test
    public void shouldSortRandomArrayInAverageCase() {
        Random random = new Random();
        int[] arr = new int[100];
        Arrays.setAll(arr, i -> random.nextInt(200));
        long startTime = System.nanoTime();
        countSort.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("Elapsed time for average case: " + (endTime - startTime) + " nanoseconds");
        assertArrayEquals(arr, Arrays.stream(arr).sorted().toArray());
    }
}