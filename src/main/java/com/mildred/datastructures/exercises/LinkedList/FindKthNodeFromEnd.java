package com.mildred.datastructures.exercises.LinkedList;

import com.mildred.datastructures.LinkedList;
import com.mildred.datastructures.Node;

/**
 * Implement a method called findKthFromEnd that returns the k-th node from the
 * end of a singly linked list. The linked list does not store its length, so you
 * must determine the correct node without using a size property.
 *
 * The value of k is 1-based.
 * You must solve this problem using the two-pointer technique, ensuring the
 * solution runs in a single traversal of the list (O(n) time, O(1) space).
 */
public class FindKthNodeFromEnd {
    static LinkedList myLinkedList = new LinkedList(1);

    public static void main(String args []) {
        // Test 1: Empty list (k = 1)
        System.out.println("Test 1: Empty List (k = 1)");

        myLinkedList.removeLast();
        Node result = findKthFromEnd(1);
        System.out.println("Expected: null");
        System.out.println("Actual: " + (result == null ? "null" : result.getValue()));
        System.out.println();

        // Test 2: One element, k = 1 (last node)
        System.out.println("Test 2: One Element (k = 1)");
        myLinkedList = new LinkedList(10);
        result = findKthFromEnd(1);
        System.out.println("10");
        System.out.println("Expected: 10");
        System.out.println("Actual: " + (result == null ? "null" : result.getValue()));
        System.out.println();

        // Test 3: One element, k = 2 (beyond end)
        System.out.println("Test 3: One Element (k = 2, Beyond End)");
        myLinkedList = new LinkedList(20);
        result = findKthFromEnd(2);
        System.out.println("20");
        System.out.println("Expected: null");
        System.out.println("Actual: " + (result == null ? "null" : result.getValue()));
        System.out.println();

        // Prepare a multi-node list
        myLinkedList = new LinkedList(1);
        for (int i = 2; i <= 6; i++) {
            myLinkedList.append(i);
        }
        // List: 1 -> 2 -> 3 -> 4 -> 5 -> 6

        // Test 4: k = 1 (last node)
        System.out.println("Test 4: Multi-Node (k = 1)");
        result = findKthFromEnd(1);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Expected: 6");
        System.out.println("Actual: " + (result == null ? "null" : result.getValue()));
        System.out.println();

        // Test 5: k = 2 (second-to-last node)
        System.out.println("Test 5: Multi-Node (k = 2)");
        result = findKthFromEnd(2);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Expected: 5");
        System.out.println("Actual: " + (result == null ? "null" : result.getValue()));
        System.out.println();

        // Test 6: k = 7 (k too large, length=6)
        System.out.println("Test 6: Multi-Node (k = 7, Too Large)");
        result = findKthFromEnd(7);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Expected: null");
        System.out.println("Actual: " + (result == null ? "null" : result.getValue()));
        System.out.println();

        // Test 7: k = 4 (middle node)
        System.out.println("Test 7: Multi-Node (k = 4)");
        result = findKthFromEnd(4);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + (result == null ? "null" : result.getValue()));
        System.out.println();
    }

    public static Node findKthFromEnd(int k) {
        if (k <= 0) return null;

        Node slow = myLinkedList.getHead();

        if(k == 1 && slow != null && slow.getNext() == null) return slow;

        Node fast = myLinkedList.getHead();
        int aux = 0;
        while(aux <= k && fast != null && fast.getNext() != null) {
            fast = fast.getNext();
            aux++;
        }

        if (aux < k) return null;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow.getNext().getNext();
    }
}
