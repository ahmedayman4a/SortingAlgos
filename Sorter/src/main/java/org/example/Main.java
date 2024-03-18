package org.example;

import org.example.Algorithms.InsertionSort;
import org.example.Algorithms.QuickSort;
import org.example.Algorithms.CountSort;
import org.example.Cli.Cli;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //test the Cli
        Scanner input = new Scanner(System.in);

        System.out.print("Enter File Path Containing List: ");
        String filePath = input.nextLine();
        Cli commandLine = new Cli(filePath);
        try{
            commandLine.get_file();
        } catch (IOException e){
            System.err.println("Error: "+ e.getMessage());
            System.exit(1);
        }
        List<Integer> list = commandLine.getList();
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        commandLine.main_menu();
        int choice;
        do {
            System.out.print("Enter an integer between 1 and 3: ");
            while (!input.hasNextInt()) {
                System.out.print("Invalid input.\nPlease enter an integer from 1 to 3: ");
                input.next(); // Consume invalid input
            }
            choice = input.nextInt();
        } while (choice < 1 || choice > 3);
        SortingContext sortingContext = null;
        String sort = switch (choice) {
            case 1 -> {
                sortingContext = new SortingContext(new InsertionSort());
                yield "Insertion Sort";
            }
            case 2 -> {
                sortingContext = new SortingContext(new QuickSort());
                yield "Quick Sort";
            }
            case 3 -> {
                sortingContext = new SortingContext(new CountSort());
                yield "Count Sort";
            }
            default -> null;
        };
        commandLine.output_choice();
        int output;
        do {
            System.out.print("Enter an integer between 1 and 2: ");
            while (!input.hasNextInt()) {
                System.out.print("Invalid input.\nPlease enter an integer from 1 or 2: ");
                input.next();
            }
            output = input.nextInt();
        } while (output < 1 || output > 2);
        System.out.println(sort);
        if(output == 1) {
                sortingContext.sort(arr);
            for(int i : arr){
                System.out.print(i + " ");
            }
        } else{
            sortingContext.sort(arr);
            List<int[]> steps = sortingContext.getSteps();
            for(int[] array : steps){
                for(int value : array){
                    System.out.print(value + " ");
                } System.out.println();
            }
        }
    }

}