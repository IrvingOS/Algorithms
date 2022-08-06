package top.irvingsoft.leetcode.code237;

import top.irvingsoft.structure.ListNode;

/**
 * 删除链表中的结点
 *
 * @author TimeChaser
 * @since 2021/11/2 7:46
 */
public class Solution {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
