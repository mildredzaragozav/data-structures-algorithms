package com.mildred.datastructures.exercises.LinkedList;

import com.mildred.datastructures.LinkedList;

/**
 * You have a singly linked list that DOES NOT HAVE A TAIL POINTER
 * (which will make this method simpler to implement).
 *
 * Given a value x you need to rearrange the linked list such that all nodes
 * with a value less than x come before all nodes with a value greater than or
 * equal to x. Additionally, the relative order of nodes in both partitions should
 * remain unchanged.
 *
 * Constraints:
 * 1. The solution should traverse the llinked list at most once.
 * 2. The solution should not create a new linked list.
 *
 * Output: The same linked list but rearranged as per the above criteria.
 */
public class PartitionList {

    public static void main(String[] args) {
        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.removeLast();
        myLinkedList.partitionList(3);
        System.out.println("List: (empty)");
        System.out.println("Expected: empty");
        myLinkedList.printList();
        System.out.println();

        // Test 2: Single node (< x)
        System.out.println("Test 2: Single Node (< x)");
        myLinkedList = new LinkedList(1);
        myLinkedList.partitionList(3);
        System.out.println("List: 1");
        System.out.println("Expected: 1");
        myLinkedList.printList();
        System.out.println();

        // Test 3: Single node (>= x)
        System.out.println("Test 3: Single Node (>= x)");
        myLinkedList = new LinkedList(5);
        myLinkedList.partitionList(3);
        System.out.println("List: 5");
        System.out.println("Expected: 5");
        myLinkedList.printList();
        System.out.println();

        // Test 4: All nodes < x
        System.out.println("Test 4: All Nodes < x");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(0);
        myLinkedList.partitionList(5);
        System.out.println("List: 1 -> 2 -> 0");
        System.out.println("Expected: 1 -> 2 -> 0");
        myLinkedList.printList();
        System.out.println();

        // Test 5: All nodes >= x
        System.out.println("Test 5: All Nodes >= x");
        myLinkedList = new LinkedList(5);
        myLinkedList.append(6);
        myLinkedList.append(7);
        myLinkedList.partitionList(5);
        System.out.println("List: 5 -> 6 -> 7");
        System.out.println("Expected: 5 -> 6 -> 7");
        myLinkedList.printList();
        System.out.println();

        // Test 6: Mixed nodes (< x and >= x)
        System.out.println("Test 6: Mixed Nodes");
        myLinkedList = new LinkedList(3);
        myLinkedList.append(5);
        myLinkedList.append(8);
        myLinkedList.append(5);
        myLinkedList.append(10);
        myLinkedList.append(2);
        myLinkedList.append(1);
        myLinkedList.partitionList(5);
        System.out.println("Original List: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1");
        System.out.println("Expected: 3 -> 2 -> 1 -> 5 -> 8 -> 5 -> 10");
        myLinkedList.printList();
        System.out.println();

        // Test 7: Nodes with duplicates around pivot
        System.out.println("Test 7: Duplicates Around Pivot");
        myLinkedList = new LinkedList(5);
        myLinkedList.append(1);
        myLinkedList.append(5);
        myLinkedList.append(0);
        myLinkedList.append(5);
        myLinkedList.partitionList(5);
        System.out.println("Original List: 5 -> 1 -> 5 -> 0 -> 5");
        System.out.println("Expected: 1 -> 0 -> 5 -> 5 -> 5");
        myLinkedList.printList();
        System.out.println();

    }

    /**
     * The function partitionList takes an integer x as a parameter and modifies
     * the current linked list in place according to the specified criteria.
     * If the linked list is empty (i.e., head is null), the function should return
     * immediately without making any changes.
     *
     * Input: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5
     * Output: 3 -> 2 -> 1 -> 8 -> 5 -> 10
     * @param x
     */
   /* private static void partitionList(int x, LinkedList myLinkedList) {
        //Node head = myLinkedList.getHead();
        if (head != null) {
            Node current = head;
            Node dummy1 = new Node(0);
            Node prev1 = dummy1;
            Node dummy2 = new Node(0);
            Node prev2 = dummy2;


            while (current != null) {
                if (current.getValue() < x) {
                    //if(dummy1.getNext() == null) dummy1.setNext(current);
                    prev1.setNext(current);
                    prev1 = current;
                } else {
                    //if(dummy2.getNext() == null) dummy2.setNext(current);
                    prev2.setNext(current);
                    prev2 = current;
                }
                current = current.getNext();
            }

            prev2.setNext(null);
            prev1.setNext(dummy2.getNext());
            head = dummy1.getNext();
        }
    }*/
}
