package top.irvingsoft.foroffer.code35;

/**
 * @author TimeChaser
 * @since 2021/12/3 9:01
 */
public class Node {
    int  val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}