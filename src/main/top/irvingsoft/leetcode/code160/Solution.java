package top.irvingsoft.leetcode.code160;

import top.irvingsoft.structure.ListNode;

/**
 * 相交链表
 *
 * @author TimeChaser
 * @since 2021/4/20 13:25
 */
public class Solution {

    /**
     * 两个指针分别从两个链表表头开始遍历，遍历完一条链表后转向另一链表
     * <p>
     * 如果有相交，必然会在转到另一条链表之后同时进入公共部分
     *
     * @author TimeChaser
     * @since 2021/10/23 15:20
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return null;
    }
}
