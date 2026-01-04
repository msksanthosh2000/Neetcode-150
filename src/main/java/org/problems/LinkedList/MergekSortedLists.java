package org.problems.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergekSortedLists {
    public static void main(String[] args) {
        int[][] lists = {
                {1, 4, 5},
                {1, 3, 4},
                {2, 6}
        };

        ListNode[] listNodes = new ListNode[lists.length];

        for (int i = 0; i < lists.length; i++) {
            listNodes[i] = buildLinkedList(lists[i]);
        }

        ListNode ans =  mergeKLists(listNodes);
        ListNode ansOp =  mergeKListsOptimized(listNodes);
        print(ans);
        print(ansOp);
    }

    // Approach 1 //
    // Brute force approach
    // Time - O(n logn)
    // Space - O(n)
    private static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        // convert it to ArrayList
        List<Integer> arr = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                arr.add(list.val);
                list = list.next;
            }
        }

        // Sort ArrayList
        Collections.sort(arr);

        // convert the array to ListNode
        for (int val: arr){
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        return dummy.next;
    }

    // Approach 2
    // Time - O(kN)
    // Space - O(1)
    private static ListNode mergeKListsOptimized(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode merged = null;
        for (ListNode list : lists) {
            merged = mergeTwoLists(merged, list);
        }

        return merged;
    }

    // Helper Method
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(Integer.MIN_VALUE);

        // Create a copy of this node to iterate while solving the problem
        ListNode headNode = resultNode;

        while (l1 != null && l2 != null){

            if(l1.val < l2.val){
                resultNode.next = l1;
                l1 = l1.next;
            }else{
                resultNode.next = l2;
                l2 = l2.next;
            }

            resultNode = resultNode.next;
        }

        // Append the remaining list
        if(l1 == null){
            resultNode.next = l2;
        } else if (l2 == null) {
            resultNode.next = l1;
        }

        // return the next node to sentinal node
        return headNode.next;
    }


    public static ListNode buildLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
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
