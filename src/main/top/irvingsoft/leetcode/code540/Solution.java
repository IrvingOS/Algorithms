package top.irvingsoft.leetcode.code540;

/**
 * 有序数组中的单一元素
 *
 * @author TimeChaser
 * @since 2022/2/14 15:10
 */
public class Solution {

    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] != nums[mid ^ 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }
}
