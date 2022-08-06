package top.irvingsoft.leetcode.code689;

/**
 * 三个无重叠子数组的最大和
 *
 * @author TimeChaser
 * @since 2021/12/8 9:26
 */
public class Solution {

    public int[] maxSumOfOneSubarray(int[] nums, int k) {
        int[] result = new int[1];
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                if (sum > maxSum) {
                    maxSum = sum;
                    result[0] = i - k + 1;
                }
                sum -= nums[i - k + 1];
            }
        }
        return result;
    }

    public int[] maxSumOfThreeSubarray(int[] nums, int k) {
        int[] result = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxSum123 = 0;
        for (int i = 2 * k; i < nums.length; i++) {
            sum1 += nums[i - 2 * k];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= 3 * k - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - 3 * k + 1;
                }
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = maxSum1 + sum2;
                    maxSum12Idx1 = maxSum1Idx;
                    maxSum12Idx2 = i - 2 * k + 1;
                }
                if (maxSum12 + sum3 > maxSum123) {
                    maxSum123 = maxSum12 + sum3;
                    result[0] = maxSum12Idx1;
                    result[1] = maxSum12Idx2;
                    result[2] = i - k + 1;
                }
                sum1 -= nums[i - 3 * k + 1];
                sum2 -= nums[i - 2 * k + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return result;
    }

    public int[] maxSumOfTwoSubarray(int[] nums, int k) {
        int[] result = new int[2];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0;
        for (int i = k; i < nums.length; i++) {
            sum1 += nums[i - k];
            sum2 += nums[i];
            if (i >= k * 2 - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - k * 2 + 1;
                }
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = maxSum1 + sum2;
                    result[0] = maxSum1Idx;
                    result[1] = i - k + 1;
                }
                sum1 -= nums[i - k * 2 + 1];
                sum2 -= nums[i - k + 1];
            }
        }
        return result;
    }

}
