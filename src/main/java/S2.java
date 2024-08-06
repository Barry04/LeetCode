import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2. 两数相加
 */
public class S2 {


    static class ListNode {
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
        Map<String, String> stringLinkedHashMap = new LinkedHashMap<>(5, 0.75F, true);

        // 输入：l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = createLinkedList(2, 2, 4);

        // 创建 l2 链表: 5 -> 6 -> 4
        ListNode l2 = createLinkedList(9);

        ListNode curr = addTwoNumbers(l1, l2);
        while (curr != null) {
            System.out.println("next.val = " + curr.val);
            curr = curr.next;
        }
    }

    /**
     * 将两个由链表表示的数字相加。
     * 每个节点包含一个数字。这些数字是以逆序方式存储的，也就是说个位数位于链表头部。
     * 每个非空链表都不含前导零，除了数字0本身。
     *
     * @param l1 第一个链表的头结点
     * @param l2 第二个链表的头结点
     * @return 相加后的新链表的头结点
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个哑节点作为结果链表的头结点
        ListNode head = new ListNode();
        // 定义两个指针 p1 和 p2 分别遍历两个链表
        ListNode p1 = l1;
        ListNode p2 = l2;
        // 定义进位标志，初始没有进位
        boolean flag = false;
        // 定义指针 res 构建结果链表，从哑节点开始
        ListNode res = head;
        // 当两个链表未遍历完或存在进位时循环
        while (p1 != null || p2 != null || flag) {
            // 初始化当前和为0
            int i = 0;
            // 如果存在进位，将当前和增加1
            if (flag) {
                i++;
            }
            // 如果第一个链表未遍历完，将当前数字加到和上并移动指针
            if (p1 != null) {
                i += p1.val;
                p1 = p1.next;
            }
            // 如果第二个链表未遍历完，将当前数字加到和上并移动指针
            if (p2 != null) {
                i += p2.val;
                p2 = p2.next;
            }
            // 如果当前和大于等于10，则设置节点值为和减去10，并标记有进位
            if (i >= 10) {
                res.val = i - 10;
                flag = true;
            } else {
                // 否则设置节点值为当前和，并清除进位标志
                res.val = i;
                flag = false;
            }
            // 如果两个链表都已遍历完且无进位，则计算完成，跳出循环
            if (p1 == null && p2 == null && !flag) {
                break;
            }
            // 如果计算未完成，则创建新节点用于下一次计算，并移动 res 指针
            res.next = new ListNode();
            res = res.next;
        }
        // 返回结果链表的头结点
        return head;
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
