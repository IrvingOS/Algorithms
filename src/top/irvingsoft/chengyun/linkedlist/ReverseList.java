package top.irvingsoft.chengyun.linkedlist;

/**
 * Page 58
 *
 * @author TimeChaser
 * @since 2021/9/17 9:54
 */
public class ReverseList {

    public static Node reverseList(Node head) {

        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseList(DoubleNode head) {

        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
