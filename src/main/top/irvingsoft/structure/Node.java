package top.irvingsoft.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义单链表
 *
 * @author TimeChaser
 * @since 2021/3/6 2:26
 */
public class Node {

    public Node left;
    public List<Node> neighbors;
    public Node next;
    public Node random;
    public Node right;
    public int val;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
        this.random = null;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
        this.random = null;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

}