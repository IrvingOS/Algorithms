package top.irvingsoft.chengyun.linkedlist;

/**
 * Page 61
 *
 * @author TimeChaser
 * @date 2021/9/17 15:16
 */
public class JosephusKill {

    public static Node josephusKill1(Node head, int m) {

        if (head == null || head.next == head || m < 1) {
            return head;
        }

        int count = 0;
        while (head.next != head) {
            count++;
            if (count == m - 1) {
                System.out.println(head.next);
                head.next = head.next.next;
                count = 0;
            }
            head = head.next;
        }
        return head;
    }

    public static Node josephusKill2(Node head, int m) {

        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node cur = head.next;
        int temp = 1;
        while (cur != head) {
            temp++;
            cur = cur.next;
        }
        temp = getLive(temp, m);
        while (--temp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    /**
     * 求 i 个节点组成的环在 m 位淘汰制中被淘汰的节点，
     * <p>
     * 可以由 i - 1 个节点组成的环在 m 位淘汰制中被淘汰的节点计算而来
     *
     * @author TimeChaser
     * @date 2021/9/18 9:24
     */
    public static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = head;

        System.out.println(josephusKill2(head, 10).toString());
    }
}
