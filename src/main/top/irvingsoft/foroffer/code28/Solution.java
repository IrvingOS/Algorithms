package top.irvingsoft.foroffer.code28;

import top.irvingsoft.structure.TreeNode;

/**
 * 对称的二叉树
 *
 * @author TimeChaser
 * @since 2021/12/1 12:50
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        } else {
            return false;
        }
    }
}
