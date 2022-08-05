package top.irvingsoft.leetcode.code700;

import top.irvingsoft.structure.TreeNode;

/**
 * 二叉搜索树中的搜索
 *
 * @author TimeChaser
 * @since 2021/11/26 11:32
 */
public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val < val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }
}
