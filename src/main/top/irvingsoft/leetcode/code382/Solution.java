package top.irvingsoft.leetcode.code382;

import top.irvingsoft.structure.ListNode;

import java.util.Random;

/**
 * 链表随机节点
 *
 * @author TimeChaser
 * @since 2022/1/16 13:37
 */
public class Solution {

    private final ListNode head;
    private final Random   random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int result = 0;
        int i = 1;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (random.nextInt(i) == 0) {
                result = cur.val;
            }
            i++;
        }
        return result;
    }
}
