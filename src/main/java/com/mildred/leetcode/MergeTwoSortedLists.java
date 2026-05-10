package com.mildred.leetcode;

public class MergeTwoSortedLists {
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
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     * Complexity for this solution:
     * Time complexity: O(n)
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode head = temp;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = new ListNode(list1.val);
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                temp = temp.next;
                list2 = list2.next;
            }
        }

        temp.next = (list1 == null ? list2 : list1);

        return head.next;
    }

    private static void printList(ListNode head) {
        System.out.print("\n [");
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.print("] \n");
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        printList(mergeTwoLists(n1, a1));

        printList(mergeTwoLists(null,null));

        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(0);
        printList(mergeTwoLists(b1,b2));


        printList(mergeTwoLists(null,b2));



    }
}
