package org.example.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements SortingAlgorithm{
    List<int[]> steps = new ArrayList<>();

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    @Override
    public List<int[]> getSteps() {
        return steps;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);

        }

    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        steps.add(arr.clone());
        return i + 1;
    }
}
