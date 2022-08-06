package top.irvingsoft.exam.leetcode.weekly.leetcode269.code5938;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组排序后的目标下标
 *
 * @author TimeChaser
 * @since 2021/11/28 15:42
 */
public class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }

}