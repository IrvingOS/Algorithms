package top.irvingsoft.leetcode.code237;

/**
 * 自定义单链表
 *
 * @author TimeChaser
 * @since 2021/3/6 2:26
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