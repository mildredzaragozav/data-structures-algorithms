package com.mildred.datastructures.exercises.LinkedList;

import com.mildred.datastructures.LinkedList;

public class BinaryToDecimal {
    public static void main(String[] args) {
        LinkedList myLinkedList;

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        myLinkedList = new LinkedList(1);
        myLinkedList.removeLast();
        System.out.println("List: (empty)");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 2: Single node (0)
        System.out.println("Test 2: Single Node (0)");
        myLinkedList = new LinkedList(0);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 0");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 3: Single node (1)
        System.out.println("Test 3: Single Node (1)");
        myLinkedList = new LinkedList(1);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 1");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 4: Multi-node (101)
        System.out.println("Test 4: Multi-Node (101)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(0);
        myLinkedList.append(1);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 5");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 5: Multi-node (1111)
        System.out.println("Test 5: Multi-Node (1111)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(1);
        myLinkedList.append(1);
        myLinkedList.append(1);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 15");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 6: Multi-node (10010)
        System.out.println("Test 6: Multi-Node (10010)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(0);
        myLinkedList.append(0);
        myLinkedList.append(1);
        myLinkedList.append(0);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 18");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();
    }
}
