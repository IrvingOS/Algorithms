package top.irvingsoft.leetcode.code698;

import java.util.Arrays;

/**
 * 划分为 k 个相等的子集
 *
 * @author TimeChaser
 * @since 20/9/2022 下午10:15
 */
public class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int index = nums.length - 1;
        if (nums[index] > target) {
            return false;
        }
        while (index >= 0 && nums[index] == target) {
            index--;
            k--;
        }
        return partition(new int[k], nums, index, target);
    }

    private boolean partition(int[] subsets, int[] nums, int index, int target) {
        if (index < 0) {
            return true;
        }
        int selected = nums[index];
        for (int i = 0; i < subsets.length; i++) {
            if (subsets[i] + selected <= target) {
                subsets[i] += selected;
                if (partition(subsets, nums, index - 1, target)) {
                    return true;
                }
                subsets[i] -= selected;
            }
        }
        return false;
    }

}
