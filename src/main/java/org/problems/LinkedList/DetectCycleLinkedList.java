package org.problems.LinkedList;

import java.util.HashSet;

public class DetectCycleLinkedList {
    public static void main(String[] args) {

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // Create cycle: node5 -> node2
        node5.next = node2;

//        System.out.println(hasCycleHashSet(head));
        System.out.println(hasCycleFloyd(head));
    }

    // Time Complexity - O(N)
    // Space Complexity - 0(N)
    private static boolean hasCycleHashSet(ListNode head){

        ListNode temp = head;

        HashSet<Integer> set = new HashSet<>();

        while(temp != null){

            if(set.contains(temp.val)){
                return true;
            }

            set.add(temp.val);
            temp = temp.next;

        }
        return false;
    }

    // Time Complexity - O(n)
    // Space Complexity - 0(1)
    public static boolean hasCycleFloyd(ListNode head) {

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(slowPtr != null && fastPtr != null && fastPtr.next !=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr){
                return true;
            }
        }

        return false;
    }
}
