package top.irvingsoft.leetcode.code623;

import top.irvingsoft.structure.TreeNode;

/**
 * 在二叉树中增加一行
 *
 * @author TimeChaser
 * @since 5/8/2022 下午4:31
 */
public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            return new TreeNode(val, root, null);
        } else if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }

}
