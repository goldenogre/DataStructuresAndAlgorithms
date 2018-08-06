package com.goldenogre.datastructures;

import java.util.Scanner;

/**
 * This class will make instances of other classes to implement data structures and algorithms
 *
 * @ Damian Depuy
 */
public class Implement {
    // sort algorithms
    private static BubbleSort bubbleSort;
    private static SelectionSort selectionSort;
    private static InsertionSort insertionSort;
    private static ShellSort shellSort;
    // search algorithms
    private static BinarySearch binarySearch;

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        int[] intArray = {51,12,41,3,18,22,8}; // Feel free to edit array with more or less integers.

        System.out.print("Sort and Search Algorithms\nNo error handling, so use correct values to" +
                " evaluate algorithm test.\nUsing test array: ");

        printList(intArray);
        System.out.println("\n----------------------------------------");

        System.out.print("\n0-Bubble Sort\n1-Insertion Sort\n" +
                "2-Selection Sort\n3-Binary Search\n4-Shell Sort\n\nChoose an algorithm to test:[0-4]");
        int choose = input.nextInt();
        switch(choose){
            case 0:
                bubbleSort = new BubbleSort();
                System.out.println("You chose bubble sort.");
                System.out.println("Choose method:\n0-normal\n1-optimized");
                int x = input.nextInt();
                if(x==0) {
                    bubbleSort.sort(intArray); // calls bubble sort class
                    System.out.println("Sorted via normal bubble sort.");
                } if(x==1){
                  bubbleSort.optimizedSort(intArray); // optimized version
                    System.out.println("Sorted via optimized bubble sort.");
                }
                break;
            case 1:
                insertionSort = new InsertionSort();
                System.out.println("You chose insertion sort.");
                insertionSort.sort(intArray);
                System.out.println("Sorted via insertion sort.");
                break;
            case 2:
                selectionSort = new SelectionSort();
                System.out.println("You chose selection sort.");
                selectionSort.sort(intArray);
                System.out.println("Sorted via selection sort.");
                break;
            case 3:
                selectionSort = new SelectionSort();
                binarySearch = new BinarySearch();
                System.out.println("You chose binary search.\nSorting via selection sort.");
                selectionSort.sort(intArray);
                System.out.println("Sorted via selection sort.");
                System.out.print("Take a look at the unsorted array and choose a number to find: ");
                int find = input.nextInt();
                System.out.println("Now choose iterative[0] or recursive[1] binary search: ");
                int y = input.nextInt();
                if(y==0){
                    System.out.println(find + " iterative search results: " + binarySearch.iterativeSearch(intArray,0,intArray.length-1,find));
                }
                if(y==1){
                    System.out.println(find + " recursive search results: " + binarySearch.recursiveSearch(intArray,0,intArray.length-1,find));
                }
                break;
            case 4:
                shellSort = new ShellSort();
                System.out.println("You chose shell sort");
                shellSort.sort(intArray);
                System.out.println("Sorted via shell sort.");

                break;


            default:
                System.out.println("You didn't choose a valid entry.");

                break;
        }

        System.out.print("Program complete.\nSorted array: ");
        printList(intArray);


    }
    public static void printList(int[]e){
        for(int x: e){
           System.out.print(x+ " ");
        }
    }
}
