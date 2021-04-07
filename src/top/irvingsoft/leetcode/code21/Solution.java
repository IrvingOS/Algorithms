package top.irvingsoft.leetcode.code21;

/**
 * @description: 合并两个有序链表
 * @author: TimeChaser
 * @date: 2021/4/7 13:32
 */
public class Solution {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = null, tail = null;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    if (head == null) {
                        head = tail = new ListNode(l1.val);
                    } else {
                        tail.next = new ListNode(l1.val);
                        tail = tail.next;
                    }
                    l1 = l1.next;
                } else {
                    if (head == null) {
                        head = tail = new ListNode(l2.val);
                    } else {
                        tail.next = new ListNode(l2.val);
                        tail = tail.next;
                    }
                    l2 = l2.next;
                }
            }
            if (l1 == null) {
                if (head == null) {
                    head = tail = new ListNode(l2.val);
                } else {
                    tail.next = new ListNode(l2.val);
                    tail = tail.next;
                }
                l2 = l2.next;
            }
            if (l2 == null) {
                if (head == null) {
                    head = tail = new ListNode(l1.val);
                } else {
                    tail.next = new ListNode(l1.val);
                    tail = tail.next;
                }
                l1 = l1.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        listNode1.val = 0;
        System.out.println(mergeTwoLists(listNode, listNode1));
    }
}

