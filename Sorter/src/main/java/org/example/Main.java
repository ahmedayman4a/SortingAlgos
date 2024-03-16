package org.example;

import org.example.Algorithms.Insertion;

public class Main {
    public static void main(String[] args) {
        Insertion insertion = new Insertion();

        SortingContext sortingContext = new SortingContext(insertion);
        int[] arr = { 12, 11, 13, 5, 6 };
        sortingContext.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int stepNumber = 1;
        for (int[] step : sortingContext.getSteps()) {
            System.out.print("Step "+ stepNumber++ + ": ");
            for (int i = 0; i < step.length; i++) {
                System.out.print(step[i] + " ");
            }
            System.out.println();
        }
    }
}