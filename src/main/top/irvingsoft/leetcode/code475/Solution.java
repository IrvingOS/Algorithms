package top.irvingsoft.leetcode.code475;

import java.util.Arrays;

/**
 * 供暖器
 *
 * @author TimeChaser
 * @since 2021/12/20 10:37
 */
public class Solution {

    public int findRadiusBinarySearch(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftRadius = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightRadius = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int curRadius = Math.min(leftRadius, rightRadius);
            result = Math.max(result, curRadius);
        }
        return result;
    }

    public int findRadiusDoublePointer(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
            }
            result = Math.max(result, Math.abs(houses[i] - heaters[j]));
        }
        return result;
    }

    /**
     * 不在数组范围内则返回 -1，在则返回小于等于目标值的下标
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return int
     */
    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums[lo] > target) {
            return -1;
        }
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
