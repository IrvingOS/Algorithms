package top.irvingsoft.leetcode.code25;

/**
 * @author TimeChaser
 * 自定义单链表
 * @date 2021/3/6 2:26
 */
public class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
        this.next = null;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}