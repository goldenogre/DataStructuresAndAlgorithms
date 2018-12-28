package com.goldenogre.algorithms;

/**
 * Merge Sort.
 * Not inplace algorithm, o(nlogn), uses temperary array for merging.
 */
public class MergeSort{
    public void mergeSort(int[] input, int start, int end){
        if(end-start < 2){ // means 1 element array.
            return;
        }
        
        // partition array with start and end
        int mid = (start + end) / 2; // end is length 
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
        
    }
    public void merge(int[] input, int start, int mid, int end){
       
       // 1st optimization
       if(input[mid-1] <= input[mid]){ // checks if array is sorted 
           return;
       }
       
       int i = start;
       int j = mid;
       int tempIndex = 0; // kees track of temp array
       
       int [] temp = new int[end-start];
       
       // compare
       while(i < mid && j < end) {
           temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++]; // = for stableness the ++ happens after in all cases.
       }
       // 2nd optimization handling elements remaining. if left, copy, right means no.
       System.arraycopy(input, i, input, start + tempIndex, mid - i); // 
       System.arraycopy(temp, 0, input, start, tempIndex);
        
    }
}
