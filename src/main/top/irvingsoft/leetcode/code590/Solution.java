package top.irvingsoft.leetcode.code590;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N 叉树的后序遍历
 *
 * @author TimeChaser
 * @since 2022/3/12 8:43 AM
 */
public class Solution {

    public List<Integer> postorderIteration(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.children != null) {
                for (Node child : node.children) {
                    stack1.push(child);
                }
            }
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }

    public List<Integer> postorderRecursion(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.children != null) {
            for (Node child : node.children) {
                dfs(child, result);
            }
        }
        result.add(node.val);
    }
}
