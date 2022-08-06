package top.irvingsoft.leetcode.code129;

import top.irvingsoft.structure.TreeNode;

/**
 * 求根节点到叶节点数字之和
 *
 * @author TimeChaser
 * @since 2022/1/13 15:25
 */
public class Solution {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int cur) {
        if (node.left == null && node.right == null) {
            sum += cur * 10 + node.val;
            return;
        }
        if (node.left != null) {
            dfs(node.left, cur * 10 + node.val);
        }
        if (node.right != null) {
            dfs(node.right, cur * 10 + node.val);
        }
    }

}
