package main.top.irvingsoft.leetcode.code1995;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计特殊四元组
 *
 * @author TimeChaser
 * @since 2021/12/29 2:42 下午
 */
public class Solution {

    public int countQuadrupletsViolence(int[] nums) {
        int result = 0;
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) {
            for (int b = a + 1; b < n - 2; b++) {
                for (int c = b + 1; c < n - 1; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public int countQuadrupletsThree(int[] nums) {
        int result = 0;
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int c = n - 2; c >= 2; c--) {
            count.put(nums[c + 1], count.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c - 1; a++) {
                for (int b = a + 1; b < c; b++) {
                    result += count.getOrDefault(nums[a] + nums[b] + nums[c], 0);
                }
            }
        }
        return result;
    }

    public int countQuadrupletsTwo(int[] nums) {
        int result = 0;
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                count.put(nums[d] - nums[b + 1], count.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; a++) {
                result += count.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return result;
    }
}
