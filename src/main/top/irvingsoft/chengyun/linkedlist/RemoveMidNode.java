package top.irvingsoft.chengyun.linkedlist;

/**
 * Page 56
 *
 * @author TimeChaser
 * @since 2021/9/17 9:33
 */
public class RemoveMidNode {

    public static Node removeMidNode(Node head) {

        // 链表为空或者仅有一个节点，不删除直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 链表仅有两个节点，删除第一个节点
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static Node removeByRadio(Node head, int a, int b) {

        if (1 < a || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / ((double) b));
        if (n == 1) {
            return head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
