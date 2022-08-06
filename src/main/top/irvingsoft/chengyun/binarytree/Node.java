package top.irvingsoft.chengyun.binarytree;

/**
 * 二叉树结点
 *
 * @author TimeChaser
 * @since 2021/9/18 10:07
 */
public class Node {

    public Node left;
    public Node right;
    public int value;

    public Node(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

}
