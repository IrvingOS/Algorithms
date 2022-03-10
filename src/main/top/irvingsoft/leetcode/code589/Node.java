package top.irvingsoft.leetcode.code589;

import java.util.List;

/**
 * 自定义单链表
 *
 * @author TimeChaser
 * @since 2021/3/6 2:26
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
}