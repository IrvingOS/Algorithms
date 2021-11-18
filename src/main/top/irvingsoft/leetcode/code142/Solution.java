package top.irvingsoft.leetcode.code142;

import java.util.HashSet;

/**
 * 面试题 02.08. 环路检测
 *
 * @author TimeChaser
 * @since 2021/9/24 18:30
 */
public class Solution {

    /**
     * 快慢指针 + 数学公式推导
     * <p>
     * 当快慢指针相遇时，头节点到入环点的距离 == 慢指针到入环点的距离
     *
     * @author TimeChaser
     * @since 2021/9/24 18:36
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }

    public static ListNode detectCycleHashSet(ListNode head) {
        ListNode cur = head;
        HashSet<ListNode> visited = new HashSet<>();
        while (cur != null) {
            if (!visited.contains(cur)) {
                visited.add(cur);
            } else {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
