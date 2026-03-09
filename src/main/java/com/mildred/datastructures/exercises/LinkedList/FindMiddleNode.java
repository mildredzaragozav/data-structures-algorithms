package com.mildred.datastructures.exercises.LinkedList;

import com.mildred.datastructures.LinkedList;
import com.mildred.datastructures.Node;

/**
 * Implement a method called findMiddleNode that returns the middle node of the
 * linked list. If the list has an even number of nodes, the method should return
 * the second middle node.
 *
 * Note: For this case you cannot use the length of the linkedlist.
 */
public class FindMiddleNode {

    public static void main(String [] args) {
        LinkedList myList = new LinkedList(1);
        /*myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Node middleNode = findMiddleNode(myList);
        System.out.println("Middle node: 3 ------> " + middleNode.getValue()); // Output: 3

        myList.append(6);
        middleNode = findMiddleNode(myList);
        System.out.println("Middle node: 4 ------> " + middleNode.getValue()); // Output: 4 */

        myList.removeLast();
        Node middleNode = findMiddleNode(myList);
        System.out.println("Middle node: null ------> " + middleNode);

        myList.append(1);
        myList.append(2);
        middleNode = findMiddleNode(myList);
        System.out.println("Middle node: 2 ------> " + middleNode.getValue()); // Output: 6 */
    }

    /**
     * This method uses the slow and fast pointer technique (aka Floyd's Tortoise and
     * Hare algorithm). The key idea is to have two pointers, one that moves twice as
     * fast as the other. By the time the fast pointer reaches the end of the linked
     * list, the slow pointer will be at the middle.
     * @param myList
     * @return
     */
    private static Node findMiddleNode(LinkedList myList) {
        Node slow = myList.getHead();
        Node fast = myList.getHead();

        if (fast == null) return slow;

        Node temp = fast.getNext();
        if (temp == null) return slow;

        while(temp.getNext() != null) {
            slow = slow.getNext();
            fast = temp.getNext();
            temp = fast.getNext();

            if (temp == null) return slow;
        }
        return slow.getNext();
    }

   /*
    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    } */

}
