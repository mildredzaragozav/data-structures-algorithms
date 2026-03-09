package com.mildred.datastructures;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public Node getHead() { return head; }
    public Node getTail() { return tail; }
    public int getLength() { return length; }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if(length == 0) return null;

        Node toRemove = tail;
        if(length == 1) {
            makeEmpty();
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
            toRemove.setPrev(null);
            length--;
        }
        return toRemove;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }else{
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if(length == 0) return null;

        Node toRemove = head;
        if (length == 1){
            makeEmpty();
        } else {
            head = head.getNext();
            head.setPrev(null);
            toRemove.setNext(null);
            length--;
        }
        return toRemove;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) return null;

        Node temp;
        if (index < length/2) {
            temp = head;
            for(int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        } else {
            temp = tail;
            for(int i = length-1; index < i; i--){
                temp = temp.getPrev();
            }
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null){
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

        if(index == length) {
            append(value);
            return true;
        }

        Node temp = get(index);
        Node newNode = new Node(value);
        Node prev = temp.getPrev();
        newNode.setPrev(prev);
        prev.setNext(newNode);
        newNode.setNext(temp);
        temp.setPrev(newNode);
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) return null;

        if(index == 0) return removeFirst();

        if(index == length-1) return removeLast();

        Node remove = get(index);
        Node prev = remove.getPrev();
        prev.setNext(remove.getNext());
        remove.getNext().setPrev(prev);
        remove.setPrev(null);
        remove.setNext(null);
        length--;
        return remove;
    }

    public void reverse() {
        if (length == 0 || length == 1) return;

        Node temp = null;
        Node current = head;

        while(current != null) {
            current.setPrev(current.getNext());
            current.setNext(temp);

            temp = current;
            current = current.getPrev();
        }

        tail = head;
        head = temp;
    }

    /**
     * Nodes with values less than `x` come before nodes with values greater than or equal to `x`.
     * @param x
     */
    public void partitionList(int x) {
        if(length == 0 || length == 1) return;
        Node d1less = new Node(0);
        Node d2greater = new Node(0);
        Node prev1 = d1less;
        Node prev2 = d2greater;
        Node current = head;

        while(current != null) {
            if(current.getValue() < x) {
                prev1.setNext(current);
                current.setPrev(prev1);
                prev1 = current;
            } else {
                prev2.setNext(current);
                current.setPrev(prev2);
                prev2 = current;
            }
            current = current.getNext();
        }

        if(d1less.getNext() != null) {
            head = d1less.getNext();
            d1less.getNext().setPrev(null);
            if(d2greater.getNext() != null) {
                prev1.setNext(d2greater.getNext());
                d2greater.getNext().setPrev(prev1);
                prev2.setNext(null);
            }
        } else if(d2greater.getNext() != null) {
            head = d2greater.getNext();
            head.setPrev(null);
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if(startIndex < 0 || endIndex >= length) return;
        if(startIndex == endIndex) return;

        Node prev;
        Node current = head;
        Node toMove;
        Node dummy = new Node(0);

        for(int i=0; i<startIndex; i++) {
            current = current.getNext();
        }

        if (current.getPrev() == null) {
            prev = dummy;
            prev.setNext(current);
        } else {
            prev = current.getPrev();
        }

        toMove = current.getNext();

        for(int i = 0; i < endIndex - startIndex ; i++) {
            current.setNext(toMove.getNext());
            if(toMove.getNext() != null) toMove.getNext().setPrev(current);
            prev.getNext().setPrev(toMove);
            toMove.setNext(prev.getNext());
            toMove.setPrev(prev);
            prev.setNext(toMove);
            toMove = current.getNext();
        }

        if(dummy.equals(prev)) {
            head = dummy.getNext();
            head.setPrev(null);
            dummy.setNext(null);
        }

    }

    public void swapPairs() {
        if(head == null || head.getNext() == null) return;

        Node dummy = new Node(0);
        Node current = head;
        head = head.getNext();

        while(current != null) {
            Node aux = current.getNext();
            if (aux != null) {
                aux.setPrev(dummy);
                current.setNext(aux.getNext());

                aux.setNext(current);
                if (current.getNext() != null) current.getNext().setPrev(current);

                current.setPrev(aux);
                dummy.setNext(aux);
                dummy = current;
                current = current.getNext();
            } else {
                break;
            }
        }

        head.getPrev().setNext(null);
        head.setPrev(null);

        /*
         * Input: 1 <-> 2 <-> 3 <-> 4
         * Output: 2 <-> 1 <-> 4 <-> 3
         * Input: 1 <-> 2 <-> 3
         * Output: 2 <-> 1 <-> 3
         */
    }

}
