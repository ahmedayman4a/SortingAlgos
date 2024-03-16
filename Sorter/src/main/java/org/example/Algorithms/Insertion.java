package org.example.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Insertion implements SortingAlgorithm {
    List<int[]> steps = new ArrayList<>();

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        steps.add(arr.clone());
        }
    }
    public List<int[]> getSteps() {
        return steps;
    }
}
