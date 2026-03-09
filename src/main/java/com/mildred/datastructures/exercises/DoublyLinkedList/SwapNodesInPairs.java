package com.mildred.datastructures.exercises.DoublyLinkedList;

import com.mildred.datastructures.DoublyLinkedList;
import com.mildred.datastructures.Node;

/**
 * This class implements a method called swapPairs within the class that swaps the values of
 * adjacent nodes in the linked list. The method should not take any input parameters.
 * Note: This DoublyLinkedLisr does not have a tail pointer which will make the implementation easier.
 * Also note, there is not a length attribute.
 */
public class SwapNodesInPairs {
    private static void printForward(DoublyLinkedList dll) {
        Node current = dll.getHead();
        if (current == null) {
            System.out.println("Forward: empty");
            return;
        }
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.println();
    }

    private static void printBackward(DoublyLinkedList dll) {
        Node current = dll.getHead();
        if (current == null) {
            System.out.println("Backward: empty");
            return;
        }
        while (current.getNext() != null) current = current.getNext(); // Go to tail
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getPrev() != null) System.out.print(" <-> ");
            current = current.getPrev();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll;

        System.out.println("We print forward and backward to confirm");
        System.out.println("that BOTH next and prev pointers work");
        System.out.println("correctly after swapPairs.");
        System.out.println();

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        dll = new DoublyLinkedList(1);
        dll.makeEmpty();
        dll.swapPairs();
        System.out.println("Expected Forward: empty");
        System.out.println("Expected Backward: empty");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 2: Single node
        System.out.println("Test 2: Single Node");
        dll = new DoublyLinkedList(10);
        dll.swapPairs();
        System.out.println("Expected Forward: 10");
        System.out.println("Expected Backward: 10");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 3: Two nodes
        System.out.println("Test 3: Two Nodes");
        dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.printList();
        dll.swapPairs();
        dll.printList();
        System.out.println("Expected Forward: 2 <-> 1");
        System.out.println("Expected Backward: 1 <-> 2");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 4: Odd number of nodes
        System.out.println("Test 4: Odd Number of Nodes");
        dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.printList();
        dll.swapPairs();
        dll.printList();
        System.out.println("Expected Forward: 2 <-> 1 <-> 3");
        System.out.println("Expected Backward: 3 <-> 1 <-> 2");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 5: Even number of nodes
        System.out.println("Test 5: Even Number of Nodes");
        dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.printList();
        dll.swapPairs();
        dll.printList();
        System.out.println("Expected Forward: 2 <-> 1 <-> 4 <-> 3");
        System.out.println("Expected Backward: 3 <-> 4 <-> 1 <-> 2");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 6: Longer list (6 nodes)
        System.out.println("Test 6: Longer List (6 Nodes)");
        dll = new DoublyLinkedList(1);
        for (int i = 2; i <= 6; i++) dll.append(i);
        dll.printList();
        dll.swapPairs();
        dll.printList();
        System.out.println("Expected Forward: 2 <-> 1 <-> 4 <-> 3 <-> 6 <-> 5");
        System.out.println("Expected Backward: 5 <-> 6 <-> 3 <-> 4 <-> 1 <-> 2");
        printForward(dll);
        printBackward(dll);
        System.out.println();
    }
}
