package top.irvingsoft.leetcode.code23;

/**
 * @description: 合并 K 个升序链表
 *
 * 1. 顺序合并
 * 2. 分治法
 * 3. 使用优先队列合并
 *
 * @author: TimeChaser
 * @date: 2021/4/19 19:54
 */

public class Solution {

    public static ListNode mergeKListsOrder(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        ListNode merge = null;
        for (ListNode list : lists) {
            merge = merge(merge, list);
        }
        return merge;
    }

    public static ListNode mergeKListsDivide(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length - 1);
    }

    public static ListNode mergeList(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int middle = (end - start) / 2 + start;
        ListNode left = mergeList(lists, start, middle);
        ListNode right = mergeList(lists, middle + 1, end);
        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right) {

        ListNode head = new ListNode();
        ListNode current = head;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = left == null ? right : left;

        return head.next;
    }

    public static void main(String[] args) {


    }
}
