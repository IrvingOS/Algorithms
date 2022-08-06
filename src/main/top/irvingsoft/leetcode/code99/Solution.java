package top.irvingsoft.leetcode.code99;

import top.irvingsoft.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 恢复二叉树
 *
 * @author TimeChaser
 * @since 2022/1/12 17:28
 */
public class Solution {

    public void recoverTreeArray(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        traverse(root, values);
        int[] swaps = swaps(values);
        swap(root, 2, swaps[0], swaps[1]);
    }

    public void recoverTreeMorris(TreeNode root) {
        TreeNode node = root;
        TreeNode prev = null, predecessor = null, x = null, y = null;
        while (node != null) {
            if (node.left != null) {
                predecessor = node.left;
                while (predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = node;
                    node = node.left;
                } else {
                    if (prev != null && prev.val > node.val) {
                        y = node;
                        if (x == null) {
                            x = prev;
                        }
                    }
                    prev = node;
                    predecessor.right = null;
                    node = node.right;
                }
            } else {
                if (prev != null && prev.val > node.val) {
                    y = node;
                    if (x == null) {
                        x = prev;
                    }
                }
                prev = node;
                node = node.right;
            }
        }
        swap(x, y);
    }

    public void recoverTreeStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null, x = null, y = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (prev != null && prev.val > node.val) {
                y = node;
                if (x == null) {
                    x = prev;
                } else {
                    break;
                }
            }
            prev = node;
            node = node.right;
        }
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    private void swap(TreeNode node, int count, int x, int y) {
        if (node != null) {
            if (node.val == x || node.val == y) {
                node.val = node.val == y ? x : y;
                if (--count == 0) {
                    return;
                }
            }
            swap(node.left, count, x, y);
            swap(node.right, count, x, y);
        }
    }

    private int[] swaps(List<Integer> values) {
        int n = values.size();
        int x = 0;
        int y = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (values.get(i) > values.get(i + 1)) {
                x = values.get(i);
                for (int j = i + 1; j < n; j++) {
                    y = Math.min(values.get(j), y);
                }
                break;
            }
        }
        return new int[]{x, y};
    }

    private void traverse(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        traverse(node.left, values);
        values.add(node.val);
        traverse(node.right, values);
    }

}
