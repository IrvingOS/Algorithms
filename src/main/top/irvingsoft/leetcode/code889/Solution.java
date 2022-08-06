package top.irvingsoft.leetcode.code889;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序和后序遍历序列构造二叉树
 * <p>
 * TODO 使用遍历构建的方法
 *
 * @author TimeChaser
 * @since 2022/3/11 4:59 PM
 */
public class Solution {

    private Map<Integer, Integer> postorderMap = new HashMap<>();

    public TreeNode constructFromPrePostIteration(int[] preorder, int[] postorder) {
        return null;
    }

    public TreeNode constructFromPrePostRecursion(int[] preorder, int[] postorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            postorderMap.put(postorder[i], i);
        }
        return dfs(preorder, 0, n - 1, 0);
    }

    private TreeNode dfs(int[] preorder, int preLeft, int preRight, int postLeft) {
        if (preLeft > preRight) {
            return null;
        }
        int nodeVal = preorder[preLeft];
        TreeNode node = new TreeNode(nodeVal);
        if (preLeft == preRight) {
            return node;
        }
        int nextPreLeft = preLeft + 1;
        int postorderIndex = postorderMap.get(preorder[nextPreLeft]);
        int leftSize = postorderIndex - postLeft;
        node.left = dfs(preorder, nextPreLeft, nextPreLeft + leftSize, postLeft);
        node.right = dfs(preorder, nextPreLeft + leftSize + 1, preRight, postorderIndex + 1);
        return node;
    }

}
