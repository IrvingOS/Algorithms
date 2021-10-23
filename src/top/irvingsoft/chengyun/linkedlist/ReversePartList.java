package top.irvingsoft.chengyun.linkedlist;

/**
 * Page 60
 *
 * @author TimeChaser
 * @date 2021/9/17 10:10
 */
public class ReversePartList {

    public static Node reversePartList(Node head, int from, int to) {

        int len = 0;
        Node cur = head;
        Node fPre = null;
        Node tPos = null;
        // 遍历长度的同时，定位好反转部分前置节点和后置节点
        while (cur != null) {
            len++;
            fPre = len == from - 1 ? cur : fPre;
            tPos = len == to + 1 ? cur : tPos;
            cur = cur.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        // 复制过后，cur 为需要反转的部分链反转前的头节点
        cur = fPre == null ? head : fPre.next;
        Node node = cur.next;
        // 反转前的头节点为反转后的尾节点，不如直接将后缀拼接到反转前的头节点之后，并从下一个节点开始翻转
        cur.next = tPos;
        Node next = null;
        while (node != tPos) {
            next = node.next;
            node.next = cur;
            cur = node;
            node = next;
        }
        // 如果前缀不为空，则进行拼接
        if (fPre != null) {
            fPre.next = cur;
            return head;
        }
        // 前缀为空，则直接返回反转后的头节点
        return cur;
    }

    public static DoubleNode reversePartList(DoubleNode head, int from, int to) {

        int len = 0;
        DoubleNode cur = head;
        DoubleNode fPre = null;
        DoubleNode tPos = null;
        while (cur != null) {
            len++;
            fPre = len == from - 1 ? cur : fPre;
            tPos = len == to + 1 ? cur : tPos;
            cur = cur.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        cur = fPre == null ? head : fPre.next;
        DoubleNode node = cur.next;
        cur.next = tPos;
        if (tPos != null) {
            tPos.last = cur;
        }
        DoubleNode next = null;
        while (node != null) {
            next = node.next;
            node.next = cur;
            node.last = next;
            cur = node;
            node = next;
        }
        if (fPre != null) {
            fPre.next = cur;
            cur.last = fPre;
            return head;
        }
        return cur;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(reversePartList(head, 1, 4).toString());
    }
}
