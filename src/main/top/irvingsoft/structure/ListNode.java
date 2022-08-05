package top.irvingsoft.structure;

/**
 * 自定义单链表
 *
 * @author TimeChaser
 * @since 2021/3/6 2:26
 */
public class ListNode {

    public ListNode next;
    public int val;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}