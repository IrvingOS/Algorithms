package top.irvingsoft.foroffer2.code55ⅰ;

/**
 * 二叉树的深度
 *
 * @author TimeChaser
 * @since 2021/12/7 14:06
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
