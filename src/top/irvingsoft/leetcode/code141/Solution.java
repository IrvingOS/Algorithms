package top.irvingsoft.leetcode.code141;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * <p>
 * 1、哈希表
 * 2、快慢指针
 *
 * @author TimeChaser
 * @date 2021/4/20 12:31
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

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
