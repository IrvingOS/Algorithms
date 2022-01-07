package top.irvingsoft.leetcode.code39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 *
 * @author TimeChaser
 * @since 2022/1/7 15:38
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int start, int value, int target, List<Integer> combination, List<List<Integer>> result) {
        if (value == target) {
            result.add(new ArrayList<>(combination));
        }
        for (int i = start; i < candidates.length; i++) {
            if (value + candidates[i] > target) {
                return;
            }
            combination.add(candidates[i]);
            dfs(candidates, i, value + candidates[i], target, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
