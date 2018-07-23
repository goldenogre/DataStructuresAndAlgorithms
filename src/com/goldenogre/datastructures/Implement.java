package com.goldenogre.datastructures;

/**
 * This class will make instances of other classes to implement data structures and algorithms
 *
 * @ Damian Depuy
 */
public class Implement {

    public static void main(String[]args){
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        int[] intArray = {5,1,4,3,1,5,1};

//        bubbleSort.sort(intArray); // calls bubble sort class
//        bubbleSort.optimizedSort(intArray); // optimized version
//        selectionSort.sort(intArray);
        insertionSort.sort(intArray);

        // Should be sorted
        printList(intArray);

    }
    public static void printList(int[]e){
        for(int x: e){
           System.out.print(x+ " ");
        }
    }



}
