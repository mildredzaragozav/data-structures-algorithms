package com.mildred.datastructures.exercises.DoublyLinkedList;

import com.mildred.datastructures.DoublyLinkedList;
import com.mildred.datastructures.Node;

public class ReverseBetween {
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
        while (current.getNext() != null) current = current.getNext();  // Go to tail
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

        // Explain why we do forward and backward prints
        System.out.println("We print each list forward and backward");
        System.out.println("to confirm BOTH next and prev pointers");
        System.out.println("are correct after reverseBetween.");
        System.out.println();

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        dll = new DoublyLinkedList(1);
        dll.makeEmpty();
        dll.reverseBetween(0,0);
        System.out.println("Expected Forward: empty");
        System.out.println("Expected Backward: empty");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 2: Single node
        System.out.println("Test 2: Single Node");
        dll = new DoublyLinkedList(10);
        dll.reverseBetween(0,0);
        System.out.println("Expected Forward: 10");
        System.out.println("Expected Backward: 10");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 3: Reverse partial (middle)
        System.out.println("Test 3: Reverse Partial (Middle)");
        dll = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) dll.append(i);
        dll.printList();
        dll.reverseBetween(1,3);  // Reverse 2,3,4
        System.out.println("Expected Forward: 1 <-> 4 <-> 3 <-> 2 <-> 5");
        System.out.println("Expected Backward: 5 <-> 2 <-> 3 <-> 4 <-> 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 4: Reverse from head
        System.out.println("Test 4: Reverse From Head");
        dll = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) dll.append(i);
        dll.reverseBetween(0,2);  // Reverse 1,2,3
        System.out.println("Expected Forward: 3 <-> 2 <-> 1 <-> 4 <-> 5");
        System.out.println("Expected Backward: 5 <-> 4 <-> 1 <-> 2 <-> 3");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 5: Reverse to tail
        System.out.println("Test 5: Reverse To Tail");
        dll = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) dll.append(i);
        dll.reverseBetween(2,4);  // Reverse 3,4,5
        System.out.println("Expected Forward: 1 <-> 2 <-> 5 <-> 4 <-> 3");
        System.out.println("Expected Backward: 3 <-> 4 <-> 5 <-> 2 <-> 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 6: Reverse entire list
        System.out.println("Test 6: Reverse Entire List");
        dll = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) dll.append(i);
        dll.reverseBetween(0,4);  // Reverse all
        System.out.println("Expected Forward: 5 <-> 4 <-> 3 <-> 2 <-> 1");
        System.out.println("Expected Backward: 1 <-> 2 <-> 3 <-> 4 <-> 5");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 7: No change (start == end)
        System.out.println("Test 7: No Change (start == end)");
        dll = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) dll.append(i);
        dll.reverseBetween(3,3);  // No change
        System.out.println("Expected Forward: 1 <-> 2 <-> 3 <-> 4 <-> 5");
        System.out.println("Expected Backward: 5 <-> 4 <-> 3 <-> 2 <-> 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();
    }
}
