package top.irvingsoft.leetcode.code590;

import java.util.List;

/**
 * N 叉树
 *
 * @author TimeChaser
 * @since 2022/3/12 8:41 AM
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};