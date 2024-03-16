package org.example;

import org.example.Algorithms.SortingAlgorithm;

import java.util.List;

public class SortingContext {
    private SortingAlgorithm sortingAlgorithm;

    public SortingContext(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void setSortingAlgorithm(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void sort(int[] arr) {
        sortingAlgorithm.sort(arr);
    }

    public List<int[]> getSteps() {
        return sortingAlgorithm.getSteps();
    }
}
