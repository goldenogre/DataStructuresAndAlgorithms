package com.goldenogre.datastructures;

import sun.invoke.empty.Empty;

import java.util.EmptyStackException;

public class ArrayStack {
    private Person[] stack;
    private int top;
    public ArrayStack(int capacity){
        stack = new Person[capacity];
    }
    public void push(Person person){
        if(top==stack.length){
            // need to resize backing array
            Person[] newArray = new Person[2*stack.length];
            System.arraycopy(stack,0,newArray,0,stack.length);
            stack = newArray;

        }
        stack[top++]= person;
    }
    public Person pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Person person = stack[--top];
        stack[top] = null;
        return person;
    }
    public Person peak(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top-1];
    }
    public int size(){
        return top;
    }
    public boolean isEmpty(){
        return top ==0; // true or false
    }
    public void printStack(){
        for(int i = top; i>=0; i--){
            System.out.println(stack[i]);
        }
    }
}
