package com.mildred.datastructures.exercises.LinkedList;

import com.mildred.datastructures.LinkedList;

public class ReverseBetween {
    public static void main(String [] args){
        LinkedList myLinkedList;

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        myLinkedList = new LinkedList(1);
        myLinkedList.removeLast();
        myLinkedList.reverseBetween(0, 0);
        System.out.println("List: (empty)");
        System.out.println("Expected: empty");
        myLinkedList.printList();
        System.out.println();

        // Test 2: Single node list
        System.out.println("Test 2: Single Node");
        myLinkedList = new LinkedList(10);
        myLinkedList.reverseBetween(0, 0);
        System.out.println("List: 10");
        System.out.println("Expected: 10");
        myLinkedList.printList();
        System.out.println();

        // Test 3: Reverse sublist in middle (1 -> 2 -> 3 -> 4 -> 5; reverse 1..3)
        System.out.println("Test 3: Reverse Sublist in Middle");
        myLinkedList = new LinkedList(1);
        for (int i = 2; i <= 5; i++) myLinkedList.append(i);
        myLinkedList.reverseBetween(1, 3);  // Reverse nodes 2,3,4
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 1 -> 4 -> 3 -> 2 -> 5");
        myLinkedList.printList();
        System.out.println();

        // Test 4: Reverse from head (reverse 0..2)
        System.out.println("Test 4: Reverse From Head");
        myLinkedList = new LinkedList(1);
        for (int i = 2; i <= 5; i++) myLinkedList.append(i);
        myLinkedList.reverseBetween(0, 2);  // Reverse nodes 1,2,3
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 3 -> 2 -> 1 -> 4 -> 5");
        myLinkedList.printList();
        System.out.println();

        // Test 5: Reverse to tail (reverse 2..4)
        System.out.println("Test 5: Reverse To Tail");
        myLinkedList = new LinkedList(1);
        for (int i = 2; i <= 5; i++) myLinkedList.append(i);
        myLinkedList.reverseBetween(2, 4);  // Reverse nodes 3,4,5
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 1 -> 2 -> 5 -> 4 -> 3");
        myLinkedList.printList();
        System.out.println();

        // Test 6: Reverse entire list (0..4)
        System.out.println("Test 6: Reverse Entire List");
        myLinkedList = new LinkedList(1);
        for (int i = 2; i <= 5; i++) myLinkedList.append(i);
        myLinkedList.reverseBetween(0, 4);
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 5 -> 4 -> 3 -> 2 -> 1");
        myLinkedList.printList();
        System.out.println();

        // Test 7: startIndex == endIndex (no change)
        System.out.println("Test 7: No Change (start == end)");
        myLinkedList = new LinkedList(1);
        for (int i = 2; i <= 5; i++) myLinkedList.append(i);
        myLinkedList.reverseBetween(2, 2);
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 1 -> 2 -> 3 -> 4 -> 5");
        myLinkedList.printList();
        System.out.println();

        System.out.println("Test 8: Reverse Sublist in Middle");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.reverseBetween(1, 2);  // Reverse nodes 2,3,4
        System.out.println("Original: 1 -> 2 -> 3");
        System.out.println("Expected: 1 -> 3 -> 2");
        myLinkedList.printList();
        System.out.println();
    }
}
