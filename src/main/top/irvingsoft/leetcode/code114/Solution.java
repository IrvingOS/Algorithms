package top.irvingsoft.leetcode.code114;

import top.irvingsoft.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树展开为链表
 *
 * @author TimeChaser
 * @since 2022/1/12 19:13
 */
public class Solution {

    public void flattenBest(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pred = next;
                while (pred.right != null) {
                    pred = pred.right;
                }
                pred.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

    public void flattenRecursionArray(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        dfs(root, nodes);
        for (int i = 1; i < nodes.size(); i++) {
            TreeNode prev = nodes.get(i - 1);
            TreeNode cur = nodes.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    public void flattenTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = cur;
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            prev = cur;
        }
    }

    public void flattenTraverseArray(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                nodes.add(node);
                stack.push(node.right);
                node = node.left;
            }
            node = stack.pop();
        }
        for (int i = 1; i < nodes.size(); i++) {
            TreeNode prev = nodes.get(i - 1);
            TreeNode cur = nodes.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    private void dfs(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(node);
        dfs(node.left, nodes);
        dfs(node.right, nodes);
    }
}
