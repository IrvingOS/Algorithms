package top.irvingsoft.leetcode.code21;

/**
 * @description: 合并两个有序链表
 * @author: TimeChaser
 * @date: 2021/4/7 13:32
 */
public class Solution {

    /**
     * @description: 迭代，然后拼接迭代后不为空的链表
     * @author: TimeChaser
     * @date: 2021/4/8 10:57
     */
    public static ListNode mergeTwoListsIteration(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();

        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return head.next;
    }

    /**
     * @description:
     *
     * 递归
     *
     * @author: TimeChaser
     * @date: 2021/4/8 10:59
     */
    public static ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        listNode1.val = 0;
        System.out.println(mergeTwoListsIteration(listNode, listNode1));
    }
}

