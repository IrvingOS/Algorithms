package top.irvingsoft.leetcode.code219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 存在重复元素 II
 *
 * @author TimeChaser
 * @since 2022/1/19 12:55 下午
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicateHash(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public boolean containsNearbyDuplicateHash(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    public boolean containsNearbyDuplicateWindow(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
