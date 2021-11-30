package top.irvingsoft.foroffer2.code24;

/**
 * 反转链表
 *
 * @author TimeChaser
 * @since 2021/11/30 12:28
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }
}
