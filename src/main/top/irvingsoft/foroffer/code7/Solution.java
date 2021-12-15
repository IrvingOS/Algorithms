package top.irvingsoft.foroffer.code7;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 重建二叉树
 *
 * @author TimeChaser
 * @since 2021/11/27 14:38
 */
public class Solution {

    /**
     * 迭代
     * <p>
     * 1. 在构建左子树时，左子树上的每一个结点都入栈
     * <p>
     * 2. 在构建右子树时，当前子树的左子树上的每一个结点都出栈，直到出栈到当前子树的根结点
     * <p>
     * 3. 在当前子树上构建右子树，将右子树的根结点入栈，对右子树的根结点构建左子树
     * <p>
     * 4. 重复上述过程
     */
    public TreeNode buildTreeIteration(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int indexInorder = 0;
        for (int i = 1; i < preorder.length; i++) {
            int valPreorder = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[indexInorder]) {
                node.left = new TreeNode(valPreorder);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[indexInorder]) {
                    node = stack.pop();
                    indexInorder++;
                }
                node.right = new TreeNode(valPreorder);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 递归
     * <p>
     * 1. preorder 序列的起始值一定为该子树的根结点的值
     * <p>
     * 2. 通过 preorder 序列的起始值在 inorder 中的索引，确定该子树左子树和右子树结点的个数
     * <p>
     * 3. 通过左子树和右子树结点的个数，确定左子树 preorder 序列的起始索引和终止索引，以此进行下一层构建
     */
    public TreeNode buildTreeRecursion(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeRecursion(0, n - 1, 0, preorder, inorderMap);
    }

    private TreeNode buildTreeRecursion(int preLeft, int preRight, int inLeft, int[] preorder, Map<Integer, Integer> inorderMap) {
        if (preLeft > preRight) {
            return null;
        }
        int nodeVal = preorder[preLeft];
        int nodeIndexIn = inorderMap.get(nodeVal);
        int sizeLeft = nodeIndexIn - inLeft;
        TreeNode node = new TreeNode(nodeVal);
        node.left = buildTreeRecursion(preLeft + 1, preLeft + sizeLeft, inLeft, preorder, inorderMap);
        node.right = buildTreeRecursion(preLeft + sizeLeft + 1, preRight, nodeIndexIn + 1, preorder, inorderMap);
        return node;
    }
}
