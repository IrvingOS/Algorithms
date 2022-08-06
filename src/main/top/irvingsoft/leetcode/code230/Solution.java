package top.irvingsoft.leetcode.code230;

import top.irvingsoft.structure.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索数中第 K 小的元素
 *
 * @author TimeChaser
 * @since 2021/11/18 10:04
 */
public class Solution {

    /**
     * 中序遍历
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root != null ? root.val : -1;
    }

}
