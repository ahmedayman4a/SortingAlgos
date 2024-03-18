package org.example.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort implements SortingAlgorithm {
    List<int[]> steps = new ArrayList<>();
    private boolean areStepsSaved = false;

    public InsertionSort() {

    }

    public InsertionSort(boolean areStepsSaved) {
        this.areStepsSaved = areStepsSaved;
    }

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
            if(areStepsSaved) {
                steps.add(arr.clone());
            }
        }
    }

    public List<int[]> getSteps() {
        return steps;
    }

    @Override
    public boolean getAreStepsSaved() {
        return areStepsSaved;
    }

    @Override
    public void setAreStepsSaved(boolean areStepsSaved) {
        this.areStepsSaved = areStepsSaved;
    }
}
