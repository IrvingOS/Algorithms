package top.irvingsoft.leetcode.code104;

/**
 * 二叉树的最大深度
 *
 * @author TimeChaser
 * @since 2021/11/13 9:39
 */
public class Solution {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
