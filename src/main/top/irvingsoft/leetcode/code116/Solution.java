package top.irvingsoft.leetcode.code116;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 填充和每个节点的下一个右侧节点指针
 *
 * @author TimeChaser
 * @since 2022/1/13 12:20
 */
public class Solution {

    public Node connectBFS(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> cur = new ArrayDeque<>();
        Deque<Node> child = new ArrayDeque<>();
        cur.offer(root);
        Node prev = null;
        while (!cur.isEmpty()) {
            Node node = cur.poll();
            node.next = prev;
            if (node.left != null) {
                child.offer(node.right);
                child.offer(node.left);
            }
            prev = node;
            if (cur.isEmpty()) {
                cur = child;
                child = new ArrayDeque<>();
                prev = null;
            }
        }
        return root;
    }

    public Node connectRecursion(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connectRecursion(root.left);
        connectRecursion(root.right);
        return root;
    }
}
