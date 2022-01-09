package top.irvingsoft.exam.leetcode.weekly.leetcode275.code5977;

/**
 * 最少交换次数来组合所有的 1 ⅱ
 *
 * @author TimeChaser
 * @since 2022/1/9 12:52
 */
public class Solution {

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            if (num == 1) {
                total++;
            }
        }
        int lo = 0;
        int hi = 0;
        int cur = 0;
        int max = 0;
        while (lo < n) {
            if (nums[hi % n] == 1) {
                cur++;
            }
            while (hi - lo >= total) {
                if (nums[lo++] == 1) {
                    cur--;
                }
            }
            max = Math.max(max, cur);
            hi++;
        }
        return total - max;
    }
}
