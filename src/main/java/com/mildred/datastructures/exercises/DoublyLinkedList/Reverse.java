package com.mildred.datastructures.exercises.DoublyLinkedList;

import com.mildred.datastructures.DoublyLinkedList;
import com.mildred.datastructures.Node;

public class Reverse {
    public static void main(String[] args) {
        // Test 4: Reverse an even-length list
        System.out.println("Test 4: Reverse Even-Length List");
        DoublyLinkedList dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        System.out.println("Head: " + dll.getHead().getValue() + " Prev: " + (dll.getHead().getPrev() != null ? dll.getHead().getPrev().getValue() : null) + " Next: " +  dll.getHead().getNext().getValue());
        System.out.println("Tail: " + dll.getTail().getValue() + " Prev: " + (dll.getTail().getPrev() != null ? dll.getTail().getPrev().getValue() : null) + " Next: " +  (dll.getTail().getNext() != null ? dll.getTail().getNext().getValue() : null));
        dll.printList();
        printForward(dll);
        printBackward(dll);
        dll.reverse();
        System.out.println("Head: " + dll.getHead().getValue() + " Prev: " + (dll.getHead().getPrev() != null ? dll.getHead().getPrev().getValue() : null) + " Next: " +  (dll.getHead().getNext() != null ? dll.getHead().getNext().getValue() : null));
        System.out.println("Tail: " + dll.getTail().getValue() + " Prev: " + (dll.getTail().getPrev() != null ? dll.getTail().getPrev().getValue() : null) + " Next: " +  (dll.getTail().getNext() != null ? dll.getTail().getNext().getValue() : null));
        dll.printList();
        printForward(dll);
        printBackward(dll);
        dll.reverse();
        System.out.println("Head: " + dll.getHead().getValue() + " Prev: " + (dll.getHead().getPrev() != null ? dll.getHead().getPrev().getValue() : null) + " Next: " +  (dll.getHead().getNext() != null ? dll.getHead().getNext().getValue() : null));
        System.out.println("Tail: " + dll.getTail().getValue() + " Prev: " + (dll.getTail().getPrev() != null ? dll.getTail().getPrev().getValue() : null) + " Next: " +  (dll.getTail().getNext() != null ? dll.getTail().getNext().getValue() : null));
        dll.printList();
        printForward(dll);
        printBackward(dll);
    }

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

    // Helper to print backward traversal
    private static void printBackward(DoublyLinkedList dll) {
        Node current = dll.getTail();
        if (current == null) {
            System.out.println("Backward: empty");
            return;
        }
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getPrev() != null) System.out.print(" <-> ");
            current = current.getPrev();
        }
        System.out.println();
    }
}
