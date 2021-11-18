package top.irvingsoft.leetcode.code563;

/**
 * 二叉树的坡度
 *
 * @author TimeChaser
 * @since 2021/11/18 9:03
 */
public class Solution {

    private int sum = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }
}
