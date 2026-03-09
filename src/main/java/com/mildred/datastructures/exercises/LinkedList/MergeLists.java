package com.mildred.datastructures.exercises.LinkedList;

import com.mildred.datastructures.LinkedList;

public class MergeLists {
    public static void main(String[] args) {

        LinkedList l1 = new LinkedList(1);
        l1.append(3);
        l1.append(5);
        l1.append(7);

        LinkedList l2 = new LinkedList(2);
        l2.append(4);
        l2.append(6);
        l2.append(8);

        l1.merge(l2);

        l1.printList();
        l1.getLength();

        System.out.println("_---------------------------------_");
        System.out.println("Tail: " + l1.getTail().getValue());



        /*
            EXPECTED OUTPUT:
            ----------------
            Head: 1
            Tail: 8
            Length:8

            Linked List:
            1
            2
            3
            4
            5
            6
            7
            8

        */

    }
}
