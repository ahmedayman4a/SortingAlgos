package org.example.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSort implements  SortingAlgorithm{
    List<int[]> steps = new ArrayList<>();

    @Override
    public void sort(int[] arr) {

        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(0);
        int[] frequency_array = new int[max - min + 1];
        for(int value : arr){
            frequency_array[value - min]++;
        }

        int index = 0;
        for(int i = 0; i < frequency_array.length; i++) {
            while (frequency_array[i] > 0) {
                arr[index++] = i + min;
                frequency_array[i]--;
                steps.add(arr.clone());
            }
        }


    }

    @Override
    public List<int[]> getSteps() {
        return steps;
    }
}
