package org.problems.LinkedList;

public class MergeTwoLinkedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(6, new ListNode(10))));
        ListNode l2 = new ListNode(4, new ListNode(7, new ListNode(9)));
        ListNode result = mergeTwoLists(l1,l2);

        printList(result);
    }


    // Time: O(n + m)
    // Space: O(1)
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode resultNode = new ListNode(Integer.MIN_VALUE);

        ListNode headNode = resultNode;
        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                resultNode.next = l1;
                l1 = l1.next;
            } else {
                resultNode.next = l2;
                l2 = l2.next;
            }

            resultNode = resultNode.next;
        }

        if(l1 == null){
            resultNode.next = l2;
        } else if (l2 == null) {
            resultNode.next = l1;
        }

        return headNode.next;
    }

    private static void printList(ListNode head) {
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


