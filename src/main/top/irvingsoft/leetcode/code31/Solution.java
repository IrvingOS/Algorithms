package top.irvingsoft.leetcode.code31;

import java.util.Arrays;

/**
 * 下一个排列
 *
 * @author TimeChaser
 * @since 2022/1/6 20:00
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean notExist = true;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j = n - 1;
                while (i < j && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
                j = n - 1;
                i++;
                while (i < j) {
                    swap(nums, i++, j--);
                }
                notExist = false;
                break;
            }
        }
        if (notExist) {
            Arrays.sort(nums);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
