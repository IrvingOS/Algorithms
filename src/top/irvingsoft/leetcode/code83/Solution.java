package top.irvingsoft.leetcode.code83;

/**
 * 删除排序链表中的重复元素
 *
 * @author TimeChaser
 * @since 2021/11/16 23:24
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            while (cur != null && cur.val == pre.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            if (cur != null) {
                cur = cur.next;
            }
        }
        return head;
    }
}
