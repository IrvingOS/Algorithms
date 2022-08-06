package top.irvingsoft.leetcode.code78;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author TimeChaser
 * @since 2021/11/13 8:49
 */
public class Solution {

    public static void backtrack(int cur, int[] nums, List<Integer> combination, List<List<Integer>> result) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(combination));
            return;
        }
        combination.add(nums[cur]);
        backtrack(cur + 1, nums, combination, result);
        combination.remove(combination.size() - 1);
        backtrack(cur + 1, nums, combination, result);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 0}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

}
