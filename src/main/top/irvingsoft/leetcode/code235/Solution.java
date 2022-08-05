package top.irvingsoft.leetcode.code235;

import top.irvingsoft.structure.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author TimeChaser
 * @since 2021/11/18 11:17
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int left = Math.min(p.val, q.val);
        int right = Math.max(p.val, q.val);
        TreeNode node = root;
        while (node != null) {
            if (left <= node.val && node.val <= right) {
                break;
            } else if (node.val < left) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }
}
