package top.irvingsoft.foroffer.code25;

import top.irvingsoft.structure.ListNode;

/**
 * 合并两个排序的队列
 *
 * @author TimeChaser
 * @since 2021/12/1 12:40
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

}
