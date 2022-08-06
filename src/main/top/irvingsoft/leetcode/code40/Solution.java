package top.irvingsoft.leetcode.code40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总数 ⅱ
 *
 * @author TimeChaser
 * @since 2022/2/19 13:34
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, 0, target, new ArrayDeque<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int begin, int cur, int target, ArrayDeque<Integer> combination,
                     List<List<Integer>> result) {
        if (cur == target) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (cur + candidates[i] > target) {
                return;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.offerLast(candidates[i]);
            dfs(candidates, i + 1, cur + candidates[i], target, combination, result);
            combination.pollLast();
        }
    }

}
