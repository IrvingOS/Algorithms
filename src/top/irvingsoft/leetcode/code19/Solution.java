package top.irvingsoft.leetcode.code19;

/**
 * @author TimeChaser
 * @date 2021/10/23 15:51
 */
public class Solution {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = findFromEnd(dummy, n + 1);
        pre.next = pre.next.next;
        return dummy.next;
    }

    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode removeNthFromEndAnother(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n--;
        }
        if (n == 0) {
            head = head.next;
        }
        if (n < 0) {
            cur = head;
            while (++n != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
