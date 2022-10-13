package top.irvingsoft.leetcode.code817;

import top.irvingsoft.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
 * 链表组件
 */
public class Solution {

    public int numComponents(ListNode head, int[] nums) {
//        使用流的方式转换会很慢
//        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        boolean prev = false;
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp.val)) {
                prev = true;
            } else if(prev) {
                count++;
                prev = false;
            }
            temp = temp.next;
        }
        if (prev) {
            count++;
        }
        return count;
    }
}
