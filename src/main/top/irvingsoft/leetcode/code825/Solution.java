package top.irvingsoft.leetcode.code825;

import java.util.Arrays;

/**
 * 适龄的朋友
 *
 * @author TimeChaser
 * @since 2021/12/27 11:01
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().numFriendRequestsCountSort(new int[]{15, 15, 15, 15, 16, 16, 16, 16, 16, 17}));
    }

    /**
     * 二分查找地位和高位的下标，然后向目标值逼近
     */
    public int numFriendRequestsBinarySearch(int[] ages) {
        Arrays.sort(ages);
        int result = 0;
        for (int age : ages) {
            int lo = age / 2 + 8;
            int loIndex = binarySearch(ages, lo, true);
            int hiIndex = binarySearch(ages, age, false);
            if (ages[loIndex] < lo) {
                loIndex++;
            }
            if (ages[hiIndex] > age) {
                hiIndex--;
            }
            result += hiIndex > loIndex ? hiIndex - loIndex : 0;
        }
        return result;
    }

    /**
     * 计数排序
     */
    public int numFriendRequestsCountSort(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) {
            ++count[age];
        }
        int[] pre = new int[121];
        for (int i = 1; i <= 120; i++) {
            pre[i] = pre[i - 1] + count[i];
        }
        int result = 0;
        for (int i = 15; i <= 120; i++) {
            if (count[i] > 0) {
                int bound = (int) (i * 0.5 + 7);
                result += count[i] * (pre[i] - pre[bound] - 1);
            }
        }
        return result;
    }

    /**
     * 双指针
     */
    public int numFriendRequestsDouble(int[] ages) {
        Arrays.sort(ages);
        int result = 0;
        int n = ages.length;
        int lo = 0;
        int hi = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[lo] <= age / 2 + 7) {
                lo++;
            }
            while (hi + 1 < n && ages[hi + 1] <= age) {
                hi++;
            }
            result += hi - lo;
        }
        return result;
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
