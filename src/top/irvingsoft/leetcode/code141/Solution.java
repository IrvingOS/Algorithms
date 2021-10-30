package top.irvingsoft.leetcode.code141;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * <p>
 * 1、哈希表
 * <p>
 * 2、快慢指针
 *
 * @author TimeChaser
 * @since 2021/4/20 12:31
 */
public class Solution {

    public static boolean hasCycleHash(ListNode head) {

        Set<ListNode> listNodeHashSet = new HashSet<>();
        while (head != null) {
            if (!listNodeHashSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycleFastAndSlow(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
