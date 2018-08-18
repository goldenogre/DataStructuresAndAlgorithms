package com.goldenogre.algorithms;

/**
 * BinarySearch has a recursive and an iterative method. Recursive uses a stack, so large arrays
 * can result in a stack overflow. Code looks nicer, but iterative is safer overall.
 */
public class BinarySearch {

    /**
     * Recursive binary search for integers.
     * Array must be sorted prior to use.
     * @param arr array to search
     * @param low start of index to search
     * @param high last index reference
     * @param key integer to search
     * @return true if found, false if not found.
     */
    public boolean recursiveSearch(int[]arr, int low, int high, int key){

        int middle = (low + high)/ 2;

        if(high < low)
            return false;
        if (key == arr[middle]) {
            return true;
        } else if(key < arr[middle]){
            return recursiveSearch(arr,low,middle-1,key);
        } else {
            return recursiveSearch(arr,middle+1,high,key);
        }
    }
    /**
     * Iterative binary search for integers.
     * Array must be sorted prior to use.
     * @param arr array to search
     * @param low start of index to search
     * @param high last index reference
     * @param key integer to search
     * @return true if found, false if not found.
     */
    public boolean iterativeSearch(int[]arr, int low, int high, int key){

        while(low <= high){
            int middle = (low + high)/2;
            if (key < arr[middle]) {
                high = middle -1;
            }
            if (key > arr[middle]) {
                low = middle +1;
            }
            if (key == arr[middle]){
                return true;
            }

        }
        return false;
    }
}
