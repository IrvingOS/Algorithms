package top.irvingsoft.leetcode.code1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 非递增顺序的最小子序列
 *
 * @author TimeChaser
 * @since 5/8/2022 下午9:52
 */
public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int cur = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            cur += nums[i];
            result.add(nums[i]);
            if (cur > sum - cur) {
                break;
            }
        }
        return result;
    }

}
