package org.problems.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode list = new ListNode(1,
                            new ListNode(2,
                                new ListNode(3,
                                    new ListNode(4,
                                        new ListNode(5)))));

        ListNode result = reverseLinkedList(list);
        printList(result);
    }

    private static ListNode reverseLinkedList(ListNode head){

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode currNode = head;

        while (currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }

        head = prev;
        return head;
    }

    private static void printList(ListNode head){

        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val);

            if(temp.next != null){
                System.out.print(" ->");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
