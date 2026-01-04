package org.problems.LinkedList;

import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4,
                new ListNode(8,
                        new ListNode(15,
                                new ListNode(16,
                                        new ListNode(23)))));

        ListNode result = reorderList(head);
        print(result);
    }

    private static ListNode reorderList(ListNode head) {

        if (head == null || head.next == null) return null;

        // Step 1: find middle
        ListNode slowPtr = head, fastPtr = head;

        while (fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Step 2: reverse second half
        ListNode prev = null, curr = slowPtr.next;

        while (curr != null) {
            ListNode nextTmp = curr.next;
             curr.next = prev;
             prev = curr;
             curr = nextTmp;

        }

        slowPtr.next = null;

        // Step 3: Merge two halves
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
        return head;
    }

    private static void print(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
