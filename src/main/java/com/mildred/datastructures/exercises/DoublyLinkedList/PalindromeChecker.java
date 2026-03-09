package com.mildred.datastructures.exercises.DoublyLinkedList;

import com.mildred.datastructures.DoublyLinkedList;
import com.mildred.datastructures.Node;

public class PalindromeChecker {

    public static void main(String [] args) {
        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        DoublyLinkedList myList = new DoublyLinkedList(1);
        myList.makeEmpty();
        System.out.println("List: (empty)");
        System.out.println("Expected: true");
        System.out.println("Actual: " + isPalindrome(myList));
        System.out.println();

        // Test 2: Single-node list
        System.out.println("Test 2: Single Node");
        DoublyLinkedList myList2 = new DoublyLinkedList(10);
        System.out.print("List: ");
        myList2.printList();
        System.out.println("Expected: true");
        System.out.println("Actual: " + isPalindrome(myList2));
        System.out.println();

        // Test 3: Two nodes (palindrome)
        System.out.println("Test 3: Two Nodes (Palindrome)");
        DoublyLinkedList myList3 = new DoublyLinkedList(5);
        myList3.append(5);
        System.out.print("List: ");
        myList3.printList();
        System.out.println("Expected: true");
        System.out.println("Actual: " + isPalindrome(myList3));
        System.out.println();

        // Test 4: Two nodes (Non-palindrome)
        System.out.println("Test 4: Two Nodes (Non-Palindrome)");
        DoublyLinkedList myList4 = new DoublyLinkedList(5);
        myList4.append(7);
        System.out.print("List: ");
        myList4.printList();
        System.out.println("Expected: false");
        System.out.println("Actual: " + isPalindrome(myList4));
        System.out.println();

        // Test 5: Odd-length palindrome (1 <-> 2 <-> 3 <-> 2 <-> 1)
        System.out.println("Test 5: Odd-Length Palindrome");
        DoublyLinkedList myList5 = new DoublyLinkedList(1);
        myList5.append(2);
        myList5.append(3);
        myList5.append(2);
        myList5.append(1);
        System.out.print("List: ");
        myList.printList();
        System.out.println("Expected: true");
        System.out.println("Actual: " + isPalindrome(myList5));
        System.out.println();

        // Test 6: Even-length palindrome (1 <-> 2 <-> 2 <-> 1)
        System.out.println("Test 6: Even-Length Palindrome");
        DoublyLinkedList myList6 = new DoublyLinkedList(1);
        myList6.append(2);
        myList6.append(2);
        myList6.append(1);
        System.out.print("List: ");
        myList6.printList();
        System.out.println("Expected: true");
        System.out.println("Actual: " + isPalindrome(myList6));
        System.out.println();

        // Test 7: Odd-length non-palindrome (1 <-> 2 <-> 3 <-> 4 <-> 1)
        System.out.println("Test 7: Odd-Length Non-Palindrome");
        DoublyLinkedList myList7 = new DoublyLinkedList(1);
        myList7.append(2);
        myList7.append(3);
        myList7.append(4);
        myList7.append(1);
        System.out.print("List: ");
        myList.printList();
        System.out.println("Expected: false");
        System.out.println("Actual: " + isPalindrome(myList7));
        System.out.println();

        // Test 8: Even-length non-palindrome (1 <-> 2 <-> 3 <-> 4)
        System.out.println("Test 8: Even-Length Non-Palindrome");
        DoublyLinkedList myList8 = new DoublyLinkedList(1);
        myList8.append(2);
        myList8.append(3);
        myList8.append(4);
        System.out.print("List: ");
        myList8.printList();
        System.out.println("Expected: false");
        System.out.println("Actual: " +isPalindrome(myList8));
        System.out.println();
    }

    public static boolean isPalindrome(DoublyLinkedList myDoubleLinkedList) {
        int length = myDoubleLinkedList.getLength();
        if (length == 0 || length == 1) return true;

        Node forward = myDoubleLinkedList.getHead();
        Node backward = myDoubleLinkedList.getTail();

        for(int i = 0; i < length/2; i++) {
            if(forward.getValue() != backward.getValue()) return false;
            forward = forward.getNext();
            backward = backward.getPrev();
        }

        return true;
    }
}
