package com.mildred.datastructures.exercises.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack;
        // Test 1: Pop single element
        System.out.println("Test 1: Pop Single Element");
        stack = new Stack<>();
        stack.push(10);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Expected Stack: empty");
        System.out.println("Actual Stack:");
        stack.printStack();
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println();
    }
}