package top.irvingsoft.chengyun.linkedlist;

/**
 * 双链表
 *
 * @author TimeChaser
 * @date 2021/9/8 11:13
 */
public class DoubleNode {

    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.value = data;
    }
}
