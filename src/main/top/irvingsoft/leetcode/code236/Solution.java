package top.irvingsoft.leetcode.code236;

/**
 * 二叉树的最近公共祖先
 *
 * @author TimeChaser
 * @since 2021/11/18 11:21
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode != null) {
            return leftNode;
        } else {
            return rightNode;
        }
    }
}
