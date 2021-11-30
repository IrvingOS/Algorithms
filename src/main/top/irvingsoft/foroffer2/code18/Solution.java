package top.irvingsoft.foroffer2.code18;

/**
 * 删除链表的结点
 *
 * @author TimeChaser
 * @since 2021/11/30 11:56
 */
public class Solution {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        for (ListNode x = dummy; x.next != null; x = x.next) {
            if (x.next.val == val) {
                x.next = x.next.next;
                break;
            }
        }
        return dummy.next;
    }
}
