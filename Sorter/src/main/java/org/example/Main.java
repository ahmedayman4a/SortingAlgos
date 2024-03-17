package org.example;

import org.example.Algorithms.InsertionSort;
import org.example.Algorithms.QuickSort;
import org.example.Algorithms.CountSort;

public class Main {
    public static void main(String[] args) {
        // test the insertion sort
        int[] arr = { 12, 11, 13, 5, 6 };
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        System.out.println("Insertion Sort");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        // test the quick sort
        int[] arr2 = { 12, 11, 13, 5, 6 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr2);
        System.out.println("Quick Sort");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
        // test the count sort
        int[] arr3 = { 12, 11, 13, 5, 6 };
        CountSort countSort = new CountSort();
        countSort.sort(arr3);
        System.out.println("Count Sort");
        for (int i : arr3) {
            System.out.print(i + " ");
        }
        System.out.println();

        // USE SortingContext
        SortingContext sortingContext = new SortingContext(new QuickSort());
        int[] arr4 = { 12, 11, 13, 5, 6 };
        sortingContext.sort(arr4);
        System.out.println("Quick Sort");
        for (int i : arr4) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}