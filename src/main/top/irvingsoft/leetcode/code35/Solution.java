package top.irvingsoft.leetcode.code35;

/**
 * 搜索插入的位置
 *
 * @author TimeChaser
 * @since 2022/1/7 10:52
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
