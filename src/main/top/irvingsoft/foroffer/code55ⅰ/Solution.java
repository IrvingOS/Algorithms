package top.irvingsoft.foroffer.code55ⅰ;

import top.irvingsoft.structure.TreeNode;

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
