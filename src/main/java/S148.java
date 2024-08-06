/**
 * 148. 排序链表
 */
public class S148 {
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

    public static void main(String[] args) {

        ListNode l1 = createLinkedList(4, 2, 1, 3);


        ListNode curr = sortList(l1);
        while (curr != null) {
            System.out.println("next.val = " + curr.val);
            curr = curr.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode curr = newHead;
        while (true) {
            ListNode node = findMaxNode(head);
            if (node.val == Integer.MAX_VALUE) {
                break;
            }
            curr.next = new ListNode(node.val);
            curr = curr.next;
            node.val = Integer.MAX_VALUE;
        }
        return newHead.next;
    }

    public static ListNode findMaxNode(ListNode head) {
        ListNode minNode = new ListNode(Integer.MAX_VALUE);
        ListNode minNodePre = head;
        while (head != null) {
            if (head.val < minNode.val) {
                minNode = head;
                minNodePre.next = head.next;
            }
            minNodePre = head;
            head = head.next;
        }
        return minNode;
    }

    // 创建链表的辅助方法
    public static ListNode createLinkedList(int... values) {
        if (values == null || values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }
}
