package top.irvingsoft.exam.leetcode.weekly.leetcode270.code5943;

import top.irvingsoft.structure.ListNode;

/**
 * 删除链表的中间结点
 *
 * @author TimeChaser
 * @since 2021/12/5 16:07
 */
public class Solution {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
