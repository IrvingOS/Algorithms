package top.irvingsoft.foroffer.code55ⅱ;

/**
 * 平衡二叉树
 *
 * @author TimeChaser
 * @since 2021/12/7 14:07
 */
public class Solution {

    public boolean isBalancedDownTop(TreeNode root) {
        return height(root) >= 0;
    }

    public boolean isBalancedTopDown(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalancedTopDown(root.left) && isBalancedTopDown(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
