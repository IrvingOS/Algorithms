package top.irvingsoft.leetcode.code113;

import top.irvingsoft.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 ⅱ
 *
 * @author TimeChaser
 * @since 2022/1/12 18:42
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int cur, int target, List<Integer> combination, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        cur += node.val;
        combination.add(node.val);
        if (cur == target) {
            if (node.left == null && node.right == null) {
                result.add(new ArrayList<>(combination));
            }
        }
        dfs(node.left, cur, target, combination, result);
        dfs(node.right, cur, target, combination, result);
        combination.remove(combination.size() - 1);
    }
}
