package top.irvingsoft.chengyun.linkedlist;

/**
 * 双链表
 *
 * @author TimeChaser
 * @since 2021/9/8 11:13
 */
public class DoubleNode {

    public DoubleNode last;
    public DoubleNode next;
    public int value;

    public DoubleNode(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "DoubleNode{" + "value=" + value + ", last=" + last + ", next=" + next + '}';
    }

}
