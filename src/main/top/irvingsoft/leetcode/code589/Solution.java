package top.irvingsoft.leetcode.code589;

import top.irvingsoft.algs4.fundamentals.stacksandqueues.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的前序遍历
 *
 * @author TimeChaser
 * @since 2022/3/10 1:05 PM
 */
public class Solution {

    public List<Integer> preorderIteration(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return result;
    }

    public List<Integer> preorderRecursion(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        result.add(node.val);
        for (Node child : node.children) {
            dfs(child, result);
        }
    }
}
