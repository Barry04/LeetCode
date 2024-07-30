import java.util.ArrayList;
import java.util.List;

/**
 * 题目： 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Code1 {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void main(String[] args) {
        ListNode head = null;
        ListNode current = null;
        for (int i = 1; i <= 0; i++) {
            ListNode newNode = new ListNode(i);
            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }
        ListNode listNode = reverseList(head);
        do {
            System.out.println("listNode.val = " + listNode.val);
            listNode = listNode.next;
        } while (listNode != null);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        ListNode curr = head;
        do {
            listNodes.add(curr);
            curr = curr.next;
        } while (curr != null);
        for (int i = listNodes.size() - 1; i >= 0; i--) {
            ListNode newHead = listNodes.get(i);

            if (i - 1 >= 0) {
                newHead.next = listNodes.get(i - 1);
            } else {
                newHead.next = null;
            }
        }
        return listNodes.get(listNodes.size() - 1);
    }

    /**
     * 优解
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
