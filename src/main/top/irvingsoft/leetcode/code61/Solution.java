package top.irvingsoft.leetcode.code61;

import top.irvingsoft.structure.ListNode;

/**
 * 旋转链表
 *
 * @author TimeChaser
 * @since 2021/11/12 18:53
 */
public class Solution {

    public static ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (length <= 1) {
            return head;
        }
        k %= length;
        if (k == 0) {
            return head;
        }
        cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        cur = head;
        while (++k != 0) {
            cur = cur.next;
        }
        ListNode pre = cur.next;
        cur.next = null;
        cur = pre;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode listNode = rotateRight(node, 7);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
