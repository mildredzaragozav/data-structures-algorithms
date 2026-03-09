package com.mildred.datastructures.exercises.Stack;

import java.util.ArrayList;

/**
 * This Stack class was built using an ArrayList instead of a LinkedList.
 * @param <T>
 */
public class Stack<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.print(stackList.get(i) + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    /**
     * The peek() method returns the top of a stack without removing it. This operation allows you to inspect
     * the most recently added element while preserving the stack's structure (LIFO - Last In, First Out).
     * @return the last element added.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        stackList.add(value);
    }

    /**
     * The pop() method in Java's java.util.Stack class removes and returns the object at the top of the stack.
     * @return the object at the top of the stack
     */
    public T pop() {
        if(isEmpty()) return null;
        return stackList.remove(size() - 1);
    }



}