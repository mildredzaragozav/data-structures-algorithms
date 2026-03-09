package com.mildred.datastructures.exercises.Queue;

import com.mildred.datastructures.exercises.Stack.Stack;

/**
 * This class implements the Enqueue Method for a Queue using Two Stacks.
 * A queue is a data structure that follows the First-In-First-Out (FIFO) principle, meaning that the first
 * element added to the queue will be the first one to be removed. Your implementation must maintain the FIFO
 * order of elements in the queue using two stacks.
 */
public class QueueUsingStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public Integer dequeue() {
        if (stack1.isEmpty()) return null;
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
