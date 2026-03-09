package com.mildred.datastructures.exercises.Stack;

public class SortStack {

    /**
     * The sortStack method takes a single argument, a Stack object.  The method should sort the elements in
     * the stack in ascending order (the lowest value will be at the top of the stack) using only one additional
     * stack.  The function should use the pop, push, peek, and isEmpty methods of the Stack object.
     * @param stack
     */
    private static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        Stack<Integer> auxStack = new Stack<>();
        auxStack.push(stack.pop());

        while(!stack.isEmpty()) {
            Integer temp = stack.pop();
            if(temp != null && auxStack.peek() != null) {
                while(!auxStack.isEmpty() && temp < auxStack.peek()) {
                    stack.push(auxStack.pop());
                }
                auxStack.push(temp);
            }
        }

        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack;

        System.out.println("These tests confirm sortStack sorts");
        System.out.println("the stack so the TOP is the LOWEST value.");
        System.out.println("printStack() shows the stack from top");
        System.out.println("to bottom (smallest to largest).");
        System.out.println();

        // Test 1: Empty stack
        System.out.println("Test 1: Empty Stack");
        stack = new Stack<>();
        sortStack(stack);
        System.out.println("Expected (top to bottom): empty");
        stack.printStack();
        System.out.println();

        // Test 2: Single element
        System.out.println("Test 2: Single Element");
        stack = new Stack<>();
        stack.push(5);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 5");
        stack.printStack();
        System.out.println();

        // Test 3: Unsorted stack
        System.out.println("Test 3: Unsorted Stack");
        stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 2, 3, 4");
        stack.printStack();
        System.out.println();

        // Test 4: Already sorted
        System.out.println("Test 4: Already Sorted Stack");
        stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 2, 3, 4");
        stack.printStack();
        System.out.println();

        // Test 5: Reverse sorted
        System.out.println("Test 5: Reverse Sorted Stack");
        stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 2, 3, 4");
        stack.printStack();
        System.out.println();

        // Test 6: With duplicates
        System.out.println("Test 6: With Duplicates");
        stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 1, 2, 3, 3");
        stack.printStack();
        System.out.println();

        // Test 7: With negatives
        System.out.println("Test 7: With Negatives");
        stack = new Stack<>();
        stack.push(-1);
        stack.push(3);
        stack.push(-5);
        stack.push(2);
        sortStack(stack);
        System.out.println("Expected (top to bottom): -5, -1, 2, 3");
        stack.printStack();
        System.out.println();
    }
}
