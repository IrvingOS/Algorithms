package top.irvingsoft.chengyun.treeheight;

/**
 * Tree 结点
 *
 * @author TimeChaser
 * @since 2021/8/6 22:28
 */
public class Node {

    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}
