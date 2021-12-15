package top.irvingsoft.foroffer.code54;

import java.util.Stack;

/**
 * 二叉搜索树的第 K 大结点
 *
 * @author TimeChaser
 * @since 2021/12/7 14:00
 */
public class Solution {

    private int k;
    private int result;

    public int kthLargestIteration(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            node = node.left;
        }
        return -1;
    }

    public int kthLargestRecursion(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            result = node.val;
            return;
        }
        dfs(node.left);
    }
}
