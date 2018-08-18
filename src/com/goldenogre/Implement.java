package com.goldenogre;

import com.goldenogre.algorithms.*;
import com.goldenogre.datastructures.ArrayStack;
import com.goldenogre.datastructures.Person;

import java.util.Scanner;

/**
 * This class will make instances of other classes to implement data structures and algorithms
 * This class only serves to implement and test sorts. I recommend looking at the algorithms
 * classes themselves to implement and study them in your own code.
 *
 * @ Damian Depuy
 */
public class Implement {

    // sort algorithms
    private static BubbleSort bubbleSort;
    private static SelectionSort selectionSort;
    private static InsertionSort insertionSort;
    private static ShellSort shellSort;

    // search algorithms
    private static BinarySearch binarySearch;

    // data structures
    private static ArrayStack stack; // stack utilizes Person class.
    
    public static void main(String[]args){
        stack = new ArrayStack(10);
        Scanner input = new Scanner(System.in);

        // Feel free to edit array with more or less integers.
        int[] intArray = {51,-24,12,41,3,-46,575,6,18,22,8,3,7,-5};

        stack.push(new Person("Damian", 37));
        stack.push(new Person("Bob", 32));
        stack.push(new Person("Santa", 107));
        stack.push(new Person("Easter Bunny", 201));
        stack.push(new Person("Chuck Norris", 78));

        stack.printStack();
    }
    public static void printList(int[]e){
        for(int x: e){
           System.out.print(x+ " ");
        }
    }
}
