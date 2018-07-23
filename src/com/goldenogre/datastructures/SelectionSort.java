package com.goldenogre.datastructures;

/**
 * Selection sort, first index is sorted. then each element is compared. The value of largest index is
 * swapped with last value, thus largest is at the end of array.
 *
 * Inplace, O(n^2) like bubble. less swapping. once per traversal.
 * Unstable!
 *
 */
public class SelectionSort {
    public void sort(int[] arr){
        for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            int largest = 0;
            for(int i = 1; i <= lastUnsortedIndex; i++){
                if(arr[i]>arr[largest]){
                    largest = i;
                }
            }
            swap(arr, largest, lastUnsortedIndex);
        }

    }
    public static void swap(int[]arr, int i, int j){
        if(i == j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
