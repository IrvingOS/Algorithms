package top.irvingsoft.leetcode.code496;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 下一个更大元素 1
 * <p>
 * 时间复杂度：O(m + n)
 *
 * @author TimeChaser
 * @since 2021/10/26 10:21
 */
public class Solution {

    /**
     * 单调栈
     * <p>
     * 时间复杂度：O(m + n)
     *
     * @since 2021/10/26 10:44
     */
    public static int[] nextGreaterElementDeque(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int nums = nums2[i];
            while (!stack.isEmpty() && nums >= stack.peek()) {
                stack.pop();
            }
            map.put(nums, stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    /**
     * 暴力递归
     * 时间复杂度：O(mn)
     *
     * @since 2021/10/26 10:43
     */
    public static int[] nextGreaterElementViolence(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n && nums1[i] != nums2[j]) {
                ++j;
            }
            int k = j + 1;
            while (k < n && nums1[i] > nums2[k]) {
                ++k;
            }
            result[i] = k < n ? nums2[k] : -1;
        }
        return result;
    }

}
