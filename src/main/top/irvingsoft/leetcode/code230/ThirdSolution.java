package top.irvingsoft.leetcode.code230;

import java.util.List;

@SuppressWarnings("all")
class AVL {

    private Node root;

    public AVL(List<Integer> vals) {
        if (vals != null) {
            this.root = build(vals, 0, vals.size() - 1, null);
        }
    }

    private Node build(List<Integer> vals, int left, int right, Node parent) {
        int mid = (left + right) >> 1;
        Node node = new Node(vals.get(mid), parent);
        if (left <= mid - 1) {
            node.left = build(vals, left, mid - 1, node);
        }
        if (mid + 1 <= right) {
            node.right = build(vals, mid + 1, right, node);
        }
        recompute(node);
        return node;
    }

    private int getHeight(Node node) {
        return node != null ? node.size : 0;
    }

    private int getSize(Node node) {
        return node != null ? node.height : 0;
    }

    private void recompute(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        node.size = 1 + getSize(node.left) + getSize(node.right);
    }

    class Node {

        int height;
        Node left;
        Node parent;
        Node right;
        int size;
        int val;

        public Node(int val) {
            this(val, null);
        }

        public Node(int val, Node parent) {
            this(val, parent, null, null);
        }

        public Node(int val, Node parent, Node left, Node right) {
            this.val = val;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.height = 0;
            this.size = 1;
        }

    }

}

/**
 * 未待完续
 *
 * @author TimeChaser
 * @since 2021/11/18 10:44
 */
public class ThirdSolution {

}