import java.util.*;
/* Studying for job interviews, I have used this class to refer to functions that
 * handle different challenges.
 */

public class Main {

    public static void main (String[]args){
        int[] sort = {5,12,55,3,5,16,52,33,11};
        int[] sort2 = {44,2,5,6,5,10,32,9,21,15,27,30,21};
        int[] test3 = {1,2,3};
        int[] test4 = {};
        printArray(sort2);
        quickSort(sort2,0,sort2.length);
        printArray(sort2);
    }
    // Intermediate Sorting Algorithms merge quick radix
    public static void radixSort(int[]arr){

    }
    public static void quickSort(int[]arr, int start, int end){
        // recursive:
        if(end-start < 2){
            return;
        }
        int pivotIndex = partition(arr,start,end);
        quickSort(arr,start,pivotIndex); // left subarray
        quickSort(arr,pivotIndex+1,end); // right subarray


    }
    public static int partition(int[]arr, int start, int end ){
        // this is using first element as pivot
        int pivot = arr[start];
        int i = start;
        int j = end;
        while(i<j){
            // empty loop body
            while(i<j && arr[--j] >= pivot);
            if(i<j){
                arr[i]=arr[j];
            }
            //empty loop again
            while (i < j && arr[++i] <= pivot);
            if(i<j){
                arr[j]=arr[i];
            }
        }
        arr[j]= pivot;
        return j;
    }
    public static void mergeSort(int[]input, int start, int end){
        // recursive: elementary sorts O(1), while mergeSort is O(n). takes some space up.

        if(end-start < 2){ // means 1 element array.
            return;
        }

        // partition array with start and end
        int mid = (start + end) / 2; // end is length
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);

    }
    public static void merge(int[]input, int start, int mid, int end){
        // 1st optimization
        if(input[mid-1] <= input[mid]){ // checks if array is sorted
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0; // keeps track of temp array
        int [] temp = new int[end-start];

        // compare
        while(i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++]; // = for stableness the ++ happens after in all cases.
        }
        // 2nd optimization handling elements remaining. if left, copy, right means no.
        System.arraycopy(input, i, input, start + tempIndex, mid - i); //
        System.arraycopy(temp, 0, input, start, tempIndex);

    }
    // Elementary Sorting Algorithmsvisualgo.net (bubble,selection,insertion)
    public static void insertionSort(int[]arr){
        // O(n^2) best case O(n)
        int j;
        for(int i = 1; i<arr.length;i++){
            int value = arr[i];
            for(j = i-1; j >=0 && arr[j]> value; j--){
                arr[j+1]= arr[j];
            }
            arr[j+1] = value;
        }
    }
    public static void selectionSort(int[]arr){
        // O(n^2)
        for(int i = 0; i < arr.length;i++) {
            int lowest = i;
            for(int j = i + 1; j < arr.length;j++){
                if(arr[j] < arr[lowest]){
                    lowest = j;
                }

            }
            // only runs if i is changed.
            if(i != lowest){
                int temp = arr[i];
                arr[i]= arr[lowest];
                arr[lowest]= temp;
            }

        }
    }
    public static void bubbleSort(int[]arr){

        // optimized with noSwap. O(N) best case
       for(int i = arr.length; i > 0; i--){
           boolean noSwaps = true;
           for(int j = 0; j < i - 1; j++){
               System.out.println( arr[j] + " "+ arr[j+1]);
               if(arr[j]>arr[j+1]){
                   int temp = arr[j];
                   arr[j]= arr[j+1];
                   arr[j+1]= temp;
                   noSwaps= false;
               }
           }
           if(noSwaps)
               break;
        }
       printArray(arr);
    }
    // Search Functions
    public static int subStringSearch(String complete, String pattern){
        int count = 0;
        for(int i = 0; i < complete.length(); i++){
            for(int j = 0; j < pattern.length();j++){
               if(pattern.charAt(j) != complete.charAt(i+j)){ // breaks loop with look ahead. i + j
                   break;
               }
               if(j == pattern.length()-1){
                   count++;
               }
            }
        }

        return count;
    }
    public static int binarySearchRecursive(int[]arr, int start, int end, int key){
        int middle = (start + end) / 2;
        if(end<start){
            return -1;
        }
        if(key < arr[middle]){
            return binarySearchRecursive(arr,start,middle-1,key);
        }
        if(key > arr[middle]){
            return binarySearchRecursive(arr,middle+1,end,key);
        }
        if(key==arr[middle]){
            return middle;
        }
        return -1;
    }
    public static int binarySearchIterative(int[]arr, int key){
        int start= 0;
        int end= arr.length-1;

        while(start<=end){
            int middle = (start + end)/2;
            if(key <arr[middle]){
                end = middle-1;
            }
            if(key>arr[middle]){
                start = middle+1;
            }
            if(key ==arr[middle]){
                return middle;
            }
        }
        return -1;
    }
    public static int linearSearch(int[]arr, int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==key)
                return i;
        }
        return -1;
    }
    // Recursion Functions
    public static int fibonacci(int n){
        if(n<=2) return 1;
        return fibonacci(n-1) + fibonacci( n-2);
    }
    public static void collectOddValues(int[]arr){
        // not recursive...
        ArrayList<Integer> list = new ArrayList<>();
        for(int x: arr){
            if(x%2!=0){
                list.add(x);
            }
        }
        System.out.println(list);
        System.out.print(Arrays.toString(list.toArray()));
    }
    public static int power(int number, int power){
        if(power==0)
            return 1;
        return number * power(number,power-1);
    }
    public static int factorial(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return n * factorial(n-1);
    }
    public static int sumRange(int num) {
        if (num == 1)
            return 1;
        else
            return num + sumRange(num-1);
    }
    public static void countDown(int n){
        if(n<=0) {
            System.out.println("Done!");
        }else {
            System.out.println(n);
            countDown(n - 1);
        }
    }
    // Functions List
    public static boolean averagePair(int[] arr, double average){
        if(arr.length==0)
            return false;
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            double ave = (arr[start]+arr[end])/2.0;
            if(ave==average)
                return true;
            else if(ave<average){
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
    public static boolean isSubsequence(String a, String b){
        // hello hello world
        if(a.length()>b.length())
            return false;
        int i = 0;
        int j = 0;
        while (j< b.length()){
            if(a.charAt(i)==b.charAt(j))
                i++;
            if(i == a.length())
                return true;
            j++;
        }
        return false;
    }
    public static boolean areThereDuplicates(int ... a){
        Map<String,Integer> map = new HashMap<>();

        for(int x : a){

            if(map.containsKey(Integer.toString(x))){
                return true;
            } else {
                map.put(Integer.toString(x),1);
            }
        }
        return false;
    }
    public static boolean sameFrequency(int a, int b){
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        if(strA.length()!=strB.length())
            return false;
        int length = strA.length();
        for(int i = 0;i <length; i++){
            char number = strA.charAt(i);
            if(map1.containsKey(number)){
                map1.put(number,map1.get(number)+1);
            } else {
                map1.put(number,1);
            }
        }
        for(int i = 0;i <length; i++){
            char number = strB.charAt(i);
            if(map2.containsKey(number)){
                map2.put(number,map2.get(number)+1);
            } else {
                map2.put(number,1);
            }
        }

        return map1.equals(map2);
    }
    public static Integer maxSubarraySum(int[]arr,int n){
        int maxSum=0;
        int tempSum=0;
        // check for large subarray
        if(n > arr.length)
            return null;
        // First subarray value
        for(int i=0; i < n; i++){
            maxSum += arr[i];
        }
        // initialize maxSum
        tempSum= maxSum;
        //
        for(int i = n; i < arr.length; i++){
            tempSum = tempSum- arr[i-n] + arr[i]; // subtracting previous index, current index.
            maxSum = Math.max(maxSum,tempSum);
        }
        return maxSum;
    }
    public static void minSubarrayLen(){
        // to do
    }
    public static void findLongestSubstring(int[] arr){
        // to do
    }
    public static int[] sumZero(int[] arr){
        int[] pair = {};
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int sum = arr[left] + arr[right];
            if(sum==0){
                pair = new int[2];
                pair[0]=arr[left];
                pair[1]=arr[right];
                return pair;
            }
            if(sum > 0){
                right--;
            } else {
                left++;
            }

        }
        return pair;
    }
    public static int countUniqueValues(int[] arr){
        int i = 0;
        if(arr.length==0)
            return 0;
        for(int j = 1; j < arr.length; j++){
           if(arr[i] != arr[j]){
               i++;
               arr[i]= arr[j];
           }
        }

        return i+1;
    }
    public static boolean anagram(String a, String b){
        Map<Character, Integer> stringA = new HashMap<>();
        Map<Character, Integer> stringB = new HashMap<>();
        if(a.length()!=b.length())
            return false;

        int length = a.length();

        for(int i = 0; i < length; i++) {
            char A = a.charAt(i);

            if (stringA.containsKey(A)) {
                stringA.put(A, stringA.get(A) + 1);
            } else {
                stringA.put(A, 1);
            }
        }
        for(int i = 0; i < length; i++) {
            char B = a.charAt(i);

            if (stringB.containsKey(B)) {
                stringB.put(B, stringB.get(B) + 1);
            } else {
                stringB.put(B, 1);
            }
        }
        System.out.println("Lookup. is there a be?");

        return stringA.equals(stringB);
    }
    public static boolean anagram1(String a, String b) {
        // Use only 1 map and remove 1 from value.
        Map<Character, Integer> map = new HashMap<>();
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            char key = a.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for(int i = 0; i < b.length(); i++){
            char key = b.charAt(i);
            if(map.get(key)>0){
                map.put(key,map.get(key)-1);
            } else {
                return false;
            }
        }
        return true;
    }
    public static void printArray(int[] a ){

        System.out.println("----------");
        for(int i = 0; i < a.length; i++){

            System.out.println("| " + i +" | " + a[i] + " |");
            System.out.println("----------");
        }
        System.out.println();
    }
}
