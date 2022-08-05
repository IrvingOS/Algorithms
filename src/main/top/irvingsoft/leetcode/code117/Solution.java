package top.irvingsoft.leetcode.code117;

import top.irvingsoft.structure.Node;

/**
 * 填充每个节点的下一个右侧节点指针 ⅱ
 *
 * @author TimeChaser
 * @since 2022/1/13 14:56
 */
public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right != null ? root.right : getNext(root.next);
        }
        if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node next) {
        while (next != null) {
            if (next.left != null || next.right != null) {
                break;
            }
            next = next.next;
        }
        return next != null ? (next.left != null ? next.left : next.right) : null;
    }
}
