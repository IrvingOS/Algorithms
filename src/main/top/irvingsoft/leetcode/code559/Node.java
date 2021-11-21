package top.irvingsoft.leetcode.code559;

import java.util.List;

/**
 * N 叉树结点
 *
 * @author TimeChaser
 * @since 2021/11/21 22:04
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
};