package top.irvingsoft.leetcode.code105;

import top.irvingsoft.algs4.fundamentals.stacksandqueues.Stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author TimeChaser
 * @since 2022/3/11 4:18 PM
 */
public class Solution {

    public TreeNode buildTreeIteration(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int inorderIndex = 0;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < n; i++) {
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }

    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTreeRecursion(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, n - 1, 0);
    }

    private TreeNode dfs(int[] preorder, int preLeft, int preRight, int inLeft) {
        if (preLeft > preRight) {
            return null;
        }
        int nodeVal = preorder[preLeft];
        int inorderIndex = inorderMap.get(nodeVal);
        int leftSize = inorderIndex - inLeft;
        TreeNode node = new TreeNode(nodeVal);
        node.left = dfs(preorder, preLeft + 1, preLeft + leftSize, inLeft);
        node.right = dfs(preorder, preLeft + leftSize + 1, preRight, inorderIndex + 1);
        return node;
    }
}
