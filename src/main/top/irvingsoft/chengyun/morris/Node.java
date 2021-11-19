package top.irvingsoft.chengyun.morris;

/**
 * Tree 结点
 *
 * @author TimeChaser
 * @since 2021/8/6 22:28
 */
public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}