package top.irvingsoft.foroffer2.code53ⅱ;

/**
 * 0 ~ n-1 中缺失的数字
 *
 * @author TimeChaser
 * @since 2021/12/7 13:57
 */
public class Solution {

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
