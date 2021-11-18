package top.irvingsoft.exam.leetcode.weekly.leetcode267.code5927;

/**
 * 反转偶数长度组的节点
 *
 * @author TimeChaser
 * @since 2021/11/14 10:38
 */
public class Solution {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int nodes = 1;
        int count = 0;
        while (fast != null) {
            count++;
            if (count == nodes) {
                if (nodes % 2 == 0) {
                    slow = reverse(slow, nodes);
                    fast = slow;
                } else {
                    slow = fast;
                }
                count = 0;
                nodes++;
            }
            fast = fast.next;
        }
        if (count > 0 && count % 2 == 0) {
            reverse(slow, count);
        }
        return head;
    }

    public ListNode reverse(ListNode pre, int count) {
        ListNode next = pre.next;
        ListNode cur = pre.next;
        ListNode sufix = cur;
        while (count-- != 0) {
            sufix = sufix.next;
        }
        ListNode node = cur.next;
        cur.next = sufix;
        while (node != sufix) {
            ListNode temp = node.next;
            node.next = cur;
            cur = node;
            node = temp;
        }
        pre.next = cur;
        return next;
    }
}
