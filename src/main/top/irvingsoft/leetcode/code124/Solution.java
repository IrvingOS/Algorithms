package top.irvingsoft.leetcode.code124;

import top.irvingsoft.structure.TreeNode;

/**
 * 二叉树的最大路径和
 *
 * @author TimeChaser
 * @since 2021/11/14 10:31
 */
public class Solution {

    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        process(root);
        return maxSum;
    }

    public static int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int mid = root.val;
        int left = Math.max(process(root.left), 0);
        int right = Math.min(process(root.right), 0);
        maxSum = Math.max(maxSum, left + mid + right);
        return mid + Math.max(left, right);
    }
}
