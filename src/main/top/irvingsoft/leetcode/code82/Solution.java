package top.irvingsoft.leetcode.code82;

import top.irvingsoft.structure.ListNode;

/**
 * 删除排序链表中的重复元素 ⅱ
 *
 * @author TimeChaser
 * @since 2021/11/17 8:56
 */
public class Solution {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int value = cur.next.val;
                while (cur.next != null && cur.next.val == value) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode = deleteDuplicates(listNode);
        while (listNode != null) {
            System.out.print(listNode.val + " : ");
            listNode = listNode.next;
        }
    }
}
