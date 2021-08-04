package top.irvingsoft.leetcode.code206;

/**
 * @author TimeChaser
 * 反转链表
 * <p>
 * 依次遍历链表，每次遍历到的节点会成为当前的已反转的部分的头节点，每次遍历到的下一个节点会成为当前的未反转的部分的头节点
 * @date 2021/4/12 11:45
 */
public class Solution {

    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void main(String[] args) {

    }
}
