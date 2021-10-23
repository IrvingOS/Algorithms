package top.irvingsoft.leetcode.code876;

/**
 * @author TimeChaser
 * @date 2021/10/23 16:36
 */
public class Solution {

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
