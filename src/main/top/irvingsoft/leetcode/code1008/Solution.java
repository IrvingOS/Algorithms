package top.irvingsoft.leetcode.code1008;

/**
 * 前序遍历构造二叉搜索树
 *
 * @author TimeChaser
 * @since 2022/3/11 6:44 PM
 */
public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[left]);
        int pivot = -1;
        for (int i = left; i <= right; i++) {
            if (preorder[i] > preorder[left]) {
                pivot = i;
                break;
            }
        }
        if (pivot != -1) {
            node.left = dfs(preorder, left + 1, pivot - 1);
            node.right = dfs(preorder, pivot, right);
        } else {
            node.left = dfs(preorder, left + 1, right);
        }
        return node;
    }
}
