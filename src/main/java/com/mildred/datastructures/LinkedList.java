package com.mildred.datastructures;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length = 0;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

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
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void removeLast() {
        if (length != 0) {
            Node temp = head;
            Node pre = head;
            while(temp.next != null) {
                pre = temp;
                temp = temp.next;
            }

            tail = pre;
            tail.next = null;
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
            while(temp.next != null) {
                pre = temp;
                temp = temp.next;
            }

            tail = pre;
            tail.next = null;
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
            newNode.next = head;
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
            head = head.next;
            length--;
        }
    }

    public Node removeFirstNode(){
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node getNode(int index){
        if (length == 0 || index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int getValue(int index){
        if (length == 0 || index < 0 || index >= length) return -999999;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public boolean set(int index, int value) {
        Node temp = getNode(index);
        if(temp != null) {
            temp.value = value;
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
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if (index < 0 || index >= length)  return null;

        if (index == 0) return removeFirstNode();
        if (index == length -1) return removeLastNode();

        Node prev = getNode(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    /**
     * This method uses returns the middle node of the linked list. If the list has an even number of nodes,
     * the method returns the second middle node. It uses the slow and fast pointer technique (aka Floyd's Tortoise and
     * Hare algorithm). The key idea is to have two pointers, one that moves twice as fast as the other. By the time the fast pointer
     * reaches the end of the linked list, the slow pointer will be at the middle.
     * @param
     * @return
     */
    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * This method detects if there is a cycle or loop present in the linked list using the Floyd's cycle-finding algorithm (also known as the
     * "tortoise and the hare" algorithm) to detect the loop.
     * @return
     */
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * This method returns the k-th node from the end of a singly linked list. This implementation does not use the
     * size property and uses the two-pointer technique.
     * Current complexity:
     * Space: O(1)
     * Time: O(n)
     * @param k
     * @return
     */
    public Node findKthFromEnd(int k) {
        if (k <= 0) return null;

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;

        while(current != null) {
            if (values.contains(current.next)) {
                previous.next = current.next;
                length--;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
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
            sum = sum*2 + current.value;
            current = current.next;
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
                if (current.value < x) {
                    //if(dummy1.next == null) dummy1.next = current);
                    prev1.next = current;
                    prev1 = current;
                } else {
                    //if(dummy2.next == null) dummy2.next = current);
                    prev2.next = current;
                    prev2 = current;
                }
                current = current.next;
            }

            prev2.next = null;
            prev1.next = dummy2.next;
            head = dummy1.next;
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
        dummy.next = head;

        if(startIndex == 0) {
            prev = dummy;
        } else {
            prev = getNode(startIndex - 1);
        }

        Node current = getNode(startIndex);
        Node stop = getNode(endIndex);
        Node toMove = current.next;

        while(toMove != stop) {
            current.next = toMove.next;
            toMove.next = prev.next;
            prev.next = toMove;
            toMove = current.next;
        }

        current.next = toMove.next;
        toMove.next = prev.next;
        prev.next = toMove;

        if(startIndex == 1) {
            head = prev;
        } else if (startIndex == 0) {
            head = prev.next;
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null || startIndex == endIndex) return;
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for(int i=0; i<startIndex; i++){
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for(int i = startIndex; 0 < endIndex-i; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }
        head = dummyNode.next;
    }

    /**
     * Swaps every two adjacents nodes in the linked list.
     * This method modifies the list in place.
     */
    public void swapPairs() {
        if(head == null || head.next == null) return;

        Node dummy = new Node(0);
        Node current = head;
        head = head.next;

        while(current != null) {
            Node aux = current.next;
            if(aux != null){
                current.next = aux.next;
                aux.next = current;
                dummy.next = aux;
                dummy = current; //dummy= aux.next;
                current = current.next;
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
                Node nextNode = current.next;
                if(nextNode.value < current.value) {
                    int nextValue = nextNode.value;
                    nextNode.value = current.value;
                    current.value = nextValue;
                }
                current = current.next;
            }
        }
    }

    public void bubbleSort2() {
        if(length < 2) return;
        Node sortedUntil = null;

        while(sortedUntil != this.head.next) {
            Node current = this.head;
            while(current.next != sortedUntil) {
                Node nextNode = current.next;
                if(current.value > nextNode.value) {
                    int nextValue = nextNode.value;
                    nextNode.value = current.value;
                    current.value = nextValue;
                }
                current = current.next;
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
        while(current.next != null) {
            // Assume current node is the smallest
            Node smallest = current;
            Node innerCurrent = current.next;

            // Inner loop to find smallest node in unsorted part
            while(innerCurrent != null) {
                if(smallest.value > innerCurrent.value) {
                    smallest = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }
            if(smallest != current) {
                int temp = smallest.value;
                smallest.value = current.value;
                current.value = temp;
            }
            current = current.next;
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
        Node unsortedListHead = head.next;
        sortedListHead.next = null;
        Node next;

        while(unsortedListHead != null) {
            next = unsortedListHead.next;

            if(unsortedListHead.value < sortedListHead.value) {
                unsortedListHead.next = sortedListHead;
                sortedListHead = unsortedListHead;
            } else {
                Node searchPointer = sortedListHead;
                while(searchPointer.next != null && searchPointer.next.value < unsortedListHead.value) {
                    searchPointer = searchPointer.next;
                }
                unsortedListHead.next = searchPointer.next;
                searchPointer.next = unsortedListHead;
            }
            unsortedListHead = next;
        }

        head = sortedListHead;

        while(sortedListHead.next != null) {
            sortedListHead = sortedListHead.next;
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
            if(otherHead.value < head.value) {
                current.next = otherHead;
                otherHead = otherHead.next;
                length++;
            } else {
                current.next = head;
                head = head.next;
            }
            current = current.next;
        }

        while(head != null){
            current.next = head;
            current = current.next;
            head = head.next;
        }

        while(otherHead != null) {
            current.next = otherHead;
            current = current.next;
            otherHead = otherHead.next;
            length++;
        }

        head = dummy.next;
        tail = current;
    }
}
