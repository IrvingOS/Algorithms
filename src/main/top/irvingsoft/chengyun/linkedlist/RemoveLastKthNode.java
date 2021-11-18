package top.irvingsoft.chengyun.linkedlist;

/**
 * Page 53
 *
 * @author TimeChaser
 * @since 2021/9/8 10:53
 */
public class RemoveLastKthNode {

    /**
     * 两次遍历找到倒数第 K 个结点的上一个结点
     *
     * @author TimeChaser
     * @since 2021/10/23 15:24
     */
    public static Node removeLastKthNodeTwoTraverse(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * 两个指针找到倒数第 K 个结点的上一个结点
     *
     * @author TimeChaser
     * @since 2021/10/23 15:42
     */
    public static Node removeLastKthNodeTwoPointer(Node head, int lastKth) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node pre = findFromEnd(dummy, lastKth + 1);
        pre.next = pre.next.next;
        return dummy.next;
    }

    public static Node findFromEnd(Node head, int k) {
        Node fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        Node slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        System.out.println(removeLastKthNodeTwoTraverse(head, 6).toString());
    }

    public static DoubleNode removeLastKthNodeTwoTraverse(DoubleNode head, int lastKth) {

        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }
}
