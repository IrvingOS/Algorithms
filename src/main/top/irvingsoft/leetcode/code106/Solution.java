package top.irvingsoft.leetcode.code106;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 从后序和中序遍历序列构造二叉树
 *
 * @author TimeChaser
 * @since 2022/3/11 4:46 PM
 */
public class Solution {

    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTreeIteration(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int inorderIndex = n - 1;
        TreeNode root = new TreeNode(postorder[n - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = n - 2; i >= 0; i--) {
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorder[i]);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorder[i]);
                stack.push(node.left);
            }
        }
        return root;
    }

    public TreeNode buildTreeRecursion(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(postorder, 0, n - 1, 0);
    }

    private TreeNode dfs(int[] postorder, int posLeft, int posRight, int inLeft) {
        if (posLeft > posRight) {
            return null;
        }
        int nodeVal = postorder[posRight];
        int inorderIndex = inorderMap.get(nodeVal);
        int leftSize = inorderIndex - inLeft;
        TreeNode node = new TreeNode(nodeVal);
        node.left = dfs(postorder, posLeft, posLeft + leftSize - 1, inLeft);
        node.right = dfs(postorder, posLeft + leftSize, posRight - 1, inorderIndex + 1);
        return node;
    }

}
