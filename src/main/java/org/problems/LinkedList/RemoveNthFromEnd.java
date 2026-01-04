package org.problems.LinkedList;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        int n = 3;

        ListNode ans = removeNthFromEnd(head, n);
        printList(ans);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n){

        ListNode dummyNode = new ListNode(-1);

        dummyNode.next = head;

        ListNode firstPtr = dummyNode;
        ListNode secPtr = dummyNode;

        for (int i = 0; i <n ; i++) {
            secPtr = secPtr.next;
        }


        while (secPtr.next != null){
            firstPtr = firstPtr.next;
            secPtr = secPtr.next;
        }

        firstPtr.next = firstPtr.next.next;

        return dummyNode.next;
    }

    private static void printList(ListNode head){

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
