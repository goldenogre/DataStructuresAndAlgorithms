package com.goldenogre.algorithms;

/**
 * inplace algorithm, O(n^2), Stable
 */
public class InsertionSort {

    public void sort(int[] arr){
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length;firstUnsortedIndex++){ // growing left to right
            int newElement = arr[firstUnsortedIndex];
            int i;
            for( i = firstUnsortedIndex; i > 0 && arr[i-1] > newElement; i--){ // down sorted partition
                arr[i] = arr[i-1];
            }
            arr[i] = newElement;
        }
    }
}
