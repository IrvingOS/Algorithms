package top.irvingsoft.leetcode.code1;

import java.util.HashMap;

/**
 * 两数之和
 * <p>
 * 解题思路：
 * 1. 暴力解法：两层 for 循环寻找和值符合条件的两个数值，返回其下标索引值数组
 * <p>
 * 2. Map 特性解法：遍历数组，检查 Map 中是否有当前数值符合条件的另一个数值的键，没有则存入当前数值作为 key 及其下标值作为 value 的键值对；
 * 有则返回当前数值的下表索引值及 Map 中符合条件的另一个数值的 value 值的数组
 *
 * @author TimeChaser
 * @author TimeChaser
 * @date 2021/3/6 2:25
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        /*for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];*/

        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length - 1);
        hashMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[0];
    }
}