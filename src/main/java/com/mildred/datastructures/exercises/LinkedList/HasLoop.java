package com.mildred.datastructures.exercises.LinkedList;

import com.mildred.datastructures.LinkedList;
import com.mildred.datastructures.Node;

/**
 * Write a method called hasLoop that is part of the linked list class.
 * The method should be able to detect if there is a cycle or loop present in the linked
 * list. You are required to use Floyd's cycle-finding algorithm (also known as the
 * "tortoise and the hare" algorithm) to detect the loop.
 *
 * This algorithm uses two pointers: a slow pointer and a fast pointer. The slow
 * pointer moves one step at a time, while the fast pointer moves two steps at a time.
 * If there is a loop in the linked list, the two pointers will eventually meet at
 * some point. If there is no loop, the fast pointer will reach the end of the list.
 */
public class HasLoop {
    public static void main(String [] args) {

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.removeLast();  // Make list empty
        System.out.println("Expected: false");
        System.out.println("Actual: " + hasLoop(myLinkedList));
        System.out.println();

        // Test 2: One node, no loop
        System.out.println("Test 2: One Node (No Loop)");
        myLinkedList = new LinkedList(1);
        System.out.println("Expected: false");
        System.out.println("Actual: " + hasLoop(myLinkedList));
        System.out.println();

        // Test 3: One node, with loop to itself
        System.out.println("Test 3: One Node (Loop to Itself)");
        myLinkedList = new LinkedList(1);
        myLinkedList.getHead().setNext(myLinkedList.getHead()); // Create loop
        System.out.println("Expected: true");
        System.out.println("Actual: " + hasLoop(myLinkedList));
        System.out.println();

        // Test 4: Multi-node, no loop
        System.out.println("Test 4: Multi-Node (No Loop)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        System.out.println("1 -> 2 -> 3 -> 4");
        System.out.println("Expected: false");
        System.out.println("Actual: " + hasLoop(myLinkedList));
        System.out.println();

        // Test 5: Multi-node, loop back to head
        System.out.println("Test 5: Multi-Node (Loop to Head)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.getTail().setNext(myLinkedList.getHead());  // Loop to head
        System.out.println("1 -> 2 -> 3 -> 4 -> (loops back to 1)");
        System.out.println("Expected: true");
        System.out.println("Actual: " + hasLoop(myLinkedList));
        System.out.println();

        // Test 6: Multi-node, loop in the middle
        System.out.println("Test 6: Multi-Node (Loop to Middle Node)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        Node middle = myLinkedList.getHead().getNext().getNext();// Node 3
        myLinkedList.getTail().setNext(middle); // Tail loops to 3
        System.out.println("1 -> 2 -> 3 -> 4 -> (loops back to 3)");
        System.out.println("Expected: true");
        System.out.println("Actual: " + hasLoop(myLinkedList));
        System.out.println();

    }

    public static boolean hasLoop(LinkedList linkedList) {
        Node slow = linkedList.getHead();
        Node fast = linkedList.getHead();

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) return true;
        }
        return false;
    }
}
