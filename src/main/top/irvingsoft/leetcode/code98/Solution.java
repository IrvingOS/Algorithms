package top.irvingsoft.leetcode.code98;

import top.irvingsoft.structure.TreeNode;

/**
 * 验证二叉搜索树
 *
 * @author TimeChaser
 * @since 2021/11/19 15:17
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, min(root) - 1, max(root) + 1);
    }

    private boolean dfs(TreeNode node, long min, long max) {
        if (!isValidNode(node, min, max)) {
            return false;
        }
        if (node.left != null && !dfs(node.left, min, node.val)) {
            return false;
        }
        if (node.right != null && !dfs(node.right, node.val, max)) {
            return false;
        }
        return true;
    }

    private boolean isValidNode(TreeNode node, long min, long max) {
        return min < node.val && node.val < max;
    }

    private long max(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        return max(node.right);
    }

    private long min(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        return min(node.left);
    }
}
