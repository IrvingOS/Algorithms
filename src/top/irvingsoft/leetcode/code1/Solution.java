package top.irvingsoft.leetcode.code1;

import java.util.HashMap;

/**
 * @description: 两数之和
 * @author: TimeChaser
 * @date: 2021/3/6 2:25
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