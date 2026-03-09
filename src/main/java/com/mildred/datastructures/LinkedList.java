package com.mildred.datastructures;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length = 0;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getTail(){
        return tail;
    }

    public Node getHead(){ return head; }

    public int getLength() { return length; }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;
    }

    public void removeLast() {
        if (length != 0) {
            Node temp = head;
            Node pre = head;
            while(temp.getNext() != null) {
                pre = temp;
                temp = temp.getNext();
            }

            tail = pre;
            tail.setNext(null);
            length--;

            if(length == 0) {
                head = null;
                tail = null;
            }

        }
    }

    public Node removeLastNode() {
        if (length == 0) return null;
        if (length != 0) {
            Node temp = head;
            Node pre = head;
            while(temp.getNext() != null) {
                pre = temp;
                temp = temp.getNext();
            }

            tail = pre;
            tail.setNext(null);
            length--;

            if(length == 0) {
                head = null;
                tail = null;
            }
            return pre;
        }
        return null;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0){
            tail = newNode;
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        length++;
    }

    public void removeFirst() {
        if (length == 1){
            head = null;
            tail = null;
            length = 0;
        } else if(length > 1) {
            head = head.getNext();
            length--;
        }
    }

    public Node removeFirstNode(){
        if(length == 0) return null;
        Node temp = head;
        head = head.getNext();
        temp.setNext(null);
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node getNode(int index){
        if (length == 0 || index < 0 || index >= length) return null;
        int aux = 0;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public int getValue(int index){
        if (length == 0 || index < 0 || index >= length) return -999999;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    public boolean set(int index, int value) {
        Node temp = getNode(index);
        if(temp != null) {
            temp.setValue(value);
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) return false;

        if(index == 0) {
            prepend(value);
            return true;
        }

        if (index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = getNode(index - 1);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        length++;
        return true;
    }

    public Node remove(int index){
        if (index < 0 || index >= length)  return null;

        if (index == 0) return removeFirstNode();
        if (index == length -1) return removeLastNode();

        Node prev = getNode(index - 1);
        Node temp = prev.getNext();
        prev.setNext(temp.getNext());
        temp.setNext(null);
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.getNext();
        Node before = null;

        for(int i = 0; i < length; i++){
            after = temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) return true;
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        if (k <= 0) return null;

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.getNext();
        }

        while (fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow;
    }

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;

        while(current != null) {
            if (values.contains(current.getNext())) {
                previous.setNext(current.getNext());
                length--;
            } else {
                values.add(current.getValue());
                previous = current;
            }
            current = current.getNext();
        }
    }

    /**
     * - This method converts a binary number, represented as a linked list, to a decimal int.
     * Return type: int
     * Returns the decimal equivalent of the binary number.
     * @return int
     */
    public int binaryToDecimal() {
        int sum = 0;
        Node current = head;

        while(current != null) {
            sum = sum*2 + current.getValue();
            current = current.getNext();
        }
        return sum;
    }

    /**
     * The function partitionList takes an integer x as a parameter and modifies the current linked list in place according to the specified criteria.
     * If the linked list is empty (i.e., head is null), the function returns immediately without making any changes.
     * Input: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5
     * Output: 3 -> 2 -> 1 -> 8 -> 5 -> 10
     * @param x
     */
    public void partitionList(int x) {
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
    }

    /**
     * This method reverses the nodes of the list between indexes startIndex and endIndex (inclusive).
     * Input: 1 -> 2 -> 3 -> 4 -> 5 reverseBetween(1,3)
     * Output: 1 -> 4 -> 3 -> 2 -> 5
     * @param startIndex
     * @param endIndex
     */
    public void reverseBetween2(int startIndex, int endIndex) {
        if(head == null || startIndex == endIndex) return;

        Node prev;
        Node dummy = new Node(0);
        dummy.setNext(head);

        if(startIndex == 0) {
            prev = dummy;
        } else {
            prev = getNode(startIndex - 1);
        }

        Node current = getNode(startIndex);
        Node stop = getNode(endIndex);
        Node toMove = current.getNext();

        while(toMove != stop) {
            current.setNext(toMove.getNext());
            toMove.setNext(prev.getNext());
            prev.setNext(toMove);
            toMove = current.getNext();
        }

        current.setNext(toMove.getNext());
        toMove.setNext(prev.getNext());
        prev.setNext(toMove);

        if(startIndex == 1) {
            head = prev;
        } else if (startIndex == 0) {
            head = prev.getNext();
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null || startIndex == endIndex) return;
        Node dummyNode = new Node(0);
        dummyNode.setNext(head);
        Node previousNode = dummyNode;

        for(int i=0; i<startIndex; i++){
            previousNode = previousNode.getNext();
        }

        Node currentNode = previousNode.getNext();

        for(int i = startIndex; 0 < endIndex-i; i++) {
            Node nodeToMove = currentNode.getNext();
            currentNode.setNext(nodeToMove.getNext());
            nodeToMove.setNext(previousNode.getNext());
            previousNode.setNext(nodeToMove);
        }
        head = dummyNode.getNext();
    }

    /**
     * Swaps every two adjacents nodes in the linked list.
     * This method modifies the list in place.
     */
    public void swapPairs() {
        if(head == null || head.getNext() == null) return;

        Node dummy = new Node(0);
        Node current = head;
        head = head.getNext();

        while(current != null) {
            Node aux = current.getNext();
            if(aux != null){
                current.setNext(aux.getNext());
                aux.setNext(current);
                dummy.setNext(aux);
                dummy = current; //dummy= aux.getNext();
                current = current.getNext();
            } else {
                break;
            }
        }
    }

    /**
     * This method sorts the elements in ascending order using the Bubble Sort algorithm. The Bubble Sort
     * algorithm works by comparing each pair of adjacent elements in the list and swapping them if the are
     * in the wrong order.
     */
    public void bubbleSort() {
        if(length < 2) return;

        for(int i=0; i<length-1; i++) {
            Node current = head;
            for(int j=1; j<length-i; j++) {
                Node nextNode = current.getNext();
                if(nextNode.getValue() < current.getValue()) {
                    int nextValue = nextNode.getValue();
                    nextNode.setValue(current.getValue());
                    current.setValue(nextValue);
                }
                current = current.getNext();
            }
        }
    }

    public void bubbleSort2() {
        if(length < 2) return;
        Node sortedUntil = null;

        while(sortedUntil != this.head.getNext()) {
            Node current = this.head;
            while(current.getNext() != sortedUntil) {
                Node nextNode = current.getNext();
                if(current.getValue() > nextNode.getValue()) {
                    int nextValue = nextNode.getValue();
                    nextNode.setValue(current.getValue());
                    current.setValue(nextValue);
                }
                current = current.getNext();
            }
            sortedUntil = current;
        }
    }

    /**
     * This method implements the Selection Sort algorithm on a singly linked list. This method
     * sort the linked list in ascending order using the Selection Sort algorithm.
     */
    public void selectionSort() {
        if(length < 2) return;

        Node current = this.head;
        while(current.getNext() != null) {
            // Assume current node is the smallest
            Node smallest = current;
            Node innerCurrent = current.getNext();

            // Inner loop to find smallest node in unsorted part
            while(innerCurrent != null) {
                if(smallest.getValue() > innerCurrent.getValue()) {
                    smallest = innerCurrent;
                }
                innerCurrent = innerCurrent.getNext();
            }
            if(smallest != current) {
                int temp = smallest.getValue();
                smallest.setValue(current.getValue());
                current.setValue(temp);
            }
            current = current.getNext();
        }
    }

    /**
     * This methods sorts the LinkedList in ascending order using the Insertion Sort algorithm.
     * The insertionSort() method sorts the linked list in place by repeatedly inserting
     * each unsorted node into its correct position in the sorted part of the list.
     */
    public void insertionSort() {
        if(length < 2) return;

        Node sortedListHead = head;
        Node unsortedListHead = head.getNext();
        sortedListHead.setNext(null);
        Node next;

        while(unsortedListHead != null) {
            next = unsortedListHead.getNext();

            if(unsortedListHead.getValue() < sortedListHead.getValue()) {
                unsortedListHead.setNext(sortedListHead);
                sortedListHead = unsortedListHead;
            } else {
                Node searchPointer = sortedListHead;
                while(searchPointer.getNext() != null && searchPointer.getNext().getValue() < unsortedListHead.getValue()) {
                    searchPointer = searchPointer.getNext();
                }
                unsortedListHead.setNext(searchPointer.getNext());
                searchPointer.setNext(unsortedListHead);
            }
            unsortedListHead = next;
        }

        head = sortedListHead;

        while(sortedListHead.getNext() != null) {
            sortedListHead = sortedListHead.getNext();
        }
        tail = sortedListHead;
    }

    /**
     * The merge method takes in another LinkedList as an input and merges it with the current LinkedList.
     * The elements in both lists are assumed to be in ascending order, but the input lists themselves do not need to be sorted.
     * @param otherList
     */
    public void merge(LinkedList otherList) {
        if (otherList == null || otherList.length == 0) return;

        Node otherHead = otherList.getHead();
        Node dummy = new Node(0);
        Node current = dummy;

        while(head != null && otherHead != null) {
            if(otherHead.getValue() < head.getValue()) {
                current.setNext(otherHead);
                otherHead = otherHead.getNext();
                length++;
            } else {
                current.setNext(head);
                head = head.getNext();
            }
            current = current.getNext();
        }

        while(head != null){
            current.setNext(head);
            current = current.getNext();
            head = head.getNext();
        }

        while(otherHead != null) {
            current.setNext(otherHead);
            current = current.getNext();
            otherHead = otherHead.getNext();
            length++;
        }

        head = dummy.getNext();
        tail = current;
    }
}
