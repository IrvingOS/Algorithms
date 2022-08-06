package top.irvingsoft.leetcode.code23;

import top.irvingsoft.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 K 个升序链表
 * <p>
 * 1. 顺序合并
 * 2. 分治法
 * 3. 使用优先队列合并
 * <p>
 * 优先队列：
 *
 * @author TimeChaser
 * @since 2021/4/19 19:54
 */

public class Solution {

    public static void main(String[] args) {

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

    /**
     * 二分归并
     *
     * @since 2021/10/22 15:47
     */
    public static ListNode mergeKListsBinary(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length - 1);
    }

    /**
     * 顺序合并
     *
     * @since 2021/10/22 15:49
     */
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

    /**
     * 优先级队列
     *
     * @since 2021/10/22 15:50
     */
    public static ListNode mergeKListsPriority(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
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

}