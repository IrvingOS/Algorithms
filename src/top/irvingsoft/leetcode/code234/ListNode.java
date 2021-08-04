package top.irvingsoft.leetcode.code234;

/**
 * @author TimeChaser
 * 自定义单链表
 * @date 2021/3/6 2:26
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}