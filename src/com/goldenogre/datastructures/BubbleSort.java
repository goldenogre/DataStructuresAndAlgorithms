package com.goldenogre.datastructures;

/**
 * Bubble Sort.
 * inplace algorithm, o(n^2), poor at higher numbers.
 * Can create a swap method. (intArray
 */
public class BubbleSort {

    public void sort(int[]arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j< n-i-1;j++){
                if(arr[j]>arr[j+1]){

                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    /**
     * Optimized: lastUnsortedIndex decrement prevents the sort to enter sorted indexes.
     * @param arr int arr
     */
    public void optimizedSort(int[] arr){
        for(int lastUnsortedIndex= arr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex --){
              for(int i = 0; i < lastUnsortedIndex; i++){
                  if(arr[i]> arr[i+1]){
                      swap(arr, i, i+1);
                  }
              }
        }
    }

    /**
     * Swaps values if i> i+1
     * @param arr integer array
     * @param i   first index
     * @param j   +1 index
     */
    public static void swap(int[]arr, int i, int j){
        if(i == j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


}
