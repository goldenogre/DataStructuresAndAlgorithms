package com.goldenogre.datastructures;

public class BinarySearch {
    public boolean search(int[]arr, int low, int high, int key){


        int middle = (low + high)/ 2;

        if(high < low)
            return false;
        if (key == arr[middle]) {
            return true;
        } else if(key < arr[middle]){
            return search(arr,low,middle-1,key);
        } else {
            return search(arr,middle+1,high,key);
        }
    }
}
