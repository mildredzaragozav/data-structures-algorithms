package com.mildred.datastructures.exercises.LinkedList;

import com.mildred.datastructures.LinkedList;

public class BubbleSortLinkedList {

    public static void name() {
        System.out.println("Unsorted Linked List:");
    }

    public static void main(String[] args) {
        name();
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(2);
        myLinkedList.append(6);
        myLinkedList.append(5);
        myLinkedList.append(1);
        myLinkedList.append(3);

        System.out.println("Unsorted Linked List:");
        myLinkedList.printList();

        myLinkedList.insertionSort();

        System.out.println("\nSorted Linked List:");
        myLinkedList.printList();

        System.out.println("\nReversed Linked List:");
        myLinkedList.reverse();
        myLinkedList.printList();


        /*
            EXPECTED OUTPUT:
            ----------------
            Unsorted Linked List:
            4
            2
            6
            5
            1
            3

            Sorted Linked List:
            1
            2
            3
            4
            5
            6

        */

    }

}
