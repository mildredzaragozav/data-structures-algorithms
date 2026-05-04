package com.mildred.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
    }

    /**
     * Complexity for this solution: O(max(N,M))
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int value1 = (l1 != null) ? l1.val : 0;
            int value2 = (l2 != null) ? l2.val : 0;
            carry += value1 + value2;

            tail.next = new ListNode(carry % 10);;
            tail = tail.next;

            carry /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 !=  null) l2 = l2.next;
        }

        return head.next;
    }

    private static void traversingList(ListNode list, ListNode tail, int previousValue) {
        while (list != null) {
            previousValue += list.val;
            ListNode tempNode = new ListNode(previousValue % 10);
            previousValue /= 10;
            tail.next = tempNode;
            tail = tempNode;
            list = list.next;
        }
    }

    private static void printListNode(ListNode list) {
        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* TEST CASE 1 */
        System.out.println("TEST CASE 1: ");
        ListNode c1 = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode l1 = new ListNode(2);
        b1.next = c1;
        l1.next = b1;
        System.out.println("L1: ");
        printListNode(l1);

        ListNode c2 = new ListNode(4);
        ListNode b2 = new ListNode(6);
        ListNode l2 = new ListNode(5);
        b2.next = c2;
        l2.next = b2;
        System.out.println("L2: ");
        printListNode(l2);

        System.out.println("Output: ");
        printListNode(addTwoNumbers(l1, l2));

        /* TEST CASE 2 */

        System.out.println("TEST CASE 2: ");
        ListNode zero = new ListNode(0);
        ListNode zero1 = new ListNode(0);
        System.out.println("L1: " );
        printListNode(zero);
        System.out.println("L2: ");
        printListNode(zero1);

        System.out.println("Output: ");
        printListNode(addTwoNumbers(zero, zero1));

        /* TEST CASE 3 */
        ListNode t1 = new ListNode(9);
        ListNode t2 = new ListNode(9);
        ListNode t3 = new ListNode(9);
        ListNode t4 = new ListNode(9);
        ListNode t5 = new ListNode(9);
        ListNode t6 = new ListNode(9);
        ListNode t7 = new ListNode(9);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = t6;
        t6.next = t7;
        System.out.println("L1: ");
        printListNode(t1);

        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("L2:");
        printListNode(n1);

        System.out.println("Output: ");
        printListNode(addTwoNumbers(t1, n1));
    }

}
