package com.mildred.datastructures;

public class Stack {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node top;
    private int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = top;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop() {
        if(height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}
