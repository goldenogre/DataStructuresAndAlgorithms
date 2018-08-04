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

        BinarySearch binarySearch = new BinarySearch();

        int[] intArray = {5,1,4,3,1,5,1};
        int find = 2; // change value as needed
        insertionSort.sort(intArray);
        System.out.println("Array sorted");
        System.out.println(find + " results: " + binarySearch.search(intArray,0,intArray.length-1,find));
//       bubbleSort.sort(intArray); // calls bubble sort class
//       bubbleSort.optimizedSort(intArray); // optimized version
//       selectionSort.sort(intArray);
//       insertionSort.sort(intArray);


        // Should be sorted
        printList(intArray);


    }
    public static void printList(int[]e){
        for(int x: e){
           System.out.print(x+ " ");
        }
    }
}
