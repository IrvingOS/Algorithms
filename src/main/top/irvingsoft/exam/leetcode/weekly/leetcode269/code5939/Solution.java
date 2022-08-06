package top.irvingsoft.exam.leetcode.weekly.leetcode269.code5939;

/**
 * 半径为 k 的子数组平均值
 *
 * @author TimeChaser
 * @since 2021/11/28 15:40
 */
public class Solution {

    public int[] getAverages(int[] nums, int k) {
        int[] result = new int[nums.length];
        int count = k * 2 + 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }
        if (count > nums.length) {
            return result;
        }
        long sum = 0;
        for (int i = 0; i < count - 1; i++) {
            sum += nums[i];
        }
        for (int i = k; i < nums.length - k; i++) {
            if (i > k) {
                sum -= nums[i - k - 1];
            }
            sum += nums[i + k];
            result[i] = (int) (sum / count);
        }
        return result;
    }

}