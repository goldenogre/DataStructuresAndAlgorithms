package com.goldenogre.datastructures;
/**
 * Knuth Sequence (3^k-1)/2 where k = array length to determine gap.
 * Simple version. Gap will be array.length/2
 * Similar to insertion sort.
 *
 * In-place algorithm; gap determines time complexity, worst case: n^2, but could be better.
 * Shell is not a stable sort. Improves upon insertion sort.
 *
 * Can also be used to improve bubble sort..
 */
public class ShellSort {
    public void sort(int[] arr){

        for(int gap = arr.length/2; gap > 0;gap /=2){ // gap values
            for(int i = gap; i < arr.length; i++){
                int newElement = arr[i];
                int j = i;
                while(j>= gap && arr[j-gap] > newElement){
                    arr[j]=arr[j-gap];
                    j-= gap;
                }
                arr[j]=newElement;
            }


        }
    }
}
