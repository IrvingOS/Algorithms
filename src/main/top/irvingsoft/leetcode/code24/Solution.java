package top.irvingsoft.leetcode.code24;

/**
 * 两两交换链表中的节点
 *
 * @author TimeChaser
 * @since 2022/1/6 14:47
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = 0;
        while (fast.next != null) {
            fast = fast.next;
            if (++count == 2) {
                ListNode temp = fast.next;
                fast.next = slow.next;
                slow.next.next = temp;
                slow.next = fast;
                slow = slow.next.next;
                fast = slow;
                count = 0;
            }
        }
        return dummy.next;
    }

    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsRecursion(head.next.next);
        newHead.next = head;
        return newHead;
    }
}
