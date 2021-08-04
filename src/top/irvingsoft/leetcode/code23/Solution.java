package top.irvingsoft.leetcode.code23;

import java.util.PriorityQueue;

/**
 * @author TimeChaser
 * 合并 K 个升序链表
 * <p>
 * 1. 顺序合并
 * 2. 分治法
 * 3. 使用优先队列合并
 * 优先队列：
 * @date 2021/4/19 19:54
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

    public static class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    public static PriorityQueue<Status> queue = new PriorityQueue<>();

    public static ListNode mergeKListsPriority(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }

    public static void main(String[] args) {


    }
}
