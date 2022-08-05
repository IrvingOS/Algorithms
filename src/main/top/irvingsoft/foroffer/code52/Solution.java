package top.irvingsoft.foroffer.code52;

import top.irvingsoft.structure.ListNode;

/**
 * 两个链表的第一个公共结点
 *
 * @author TimeChaser
 * @since 2021/12/6 15:14
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            } else {
                curA = curA.next;
            }
            if (curB == null) {
                curB = headA;
            } else {
                curB = curB.next;
            }
        }
        return curA;
    }
}
