package top.irvingsoft.foroffer.code6;

import top.irvingsoft.structure.ListNode;

/**
 * 从尾到头打印链表
 *
 * @author TimeChaser
 * @since 2021/11/24 21:28
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] result = new int[count];
        int i = count - 1;
        cur = head;
        while (cur != null) {
            result[i--] = cur.val;
            cur = cur.next;
        }
        return result;
    }

}
