package top.irvingsoft.chengyun.linkedlist;

import java.util.Stack;

/**
 * Page 66
 *
 * @author TimeChaser
 * @author TimeChaser
 * @date 2021/9/18 9:27
 */
public class Palindrome {

    public static boolean isPalindrome1(Node head) {

        Stack<Node> nodeStack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            nodeStack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != nodeStack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {

        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        // 定位 right 指针到右半区头节点
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> nodeStack = new Stack<>();
        while (right != null) {
            nodeStack.push(right);
            right = right.next;
        }
        while (!nodeStack.isEmpty()) {
            if (head.value != nodeStack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {

        if (head == null || head.next == null) {
            return true;
        }
        Node node1 = head;
        Node node2 = head;
        // 定位 node1 指针到中间节点
        while (node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        node2 = node1.next;
        node1.next = null;
        Node node3 = null;
        while (node2 != null) {
            node3 = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = node3;
        }
        node2 = head;
        node3 = node1;
        boolean result = true;
        // node2 从前往中间节点遍历，node1 从后往中间节点遍历
        while (node2 != null && node1 != null) {
            if (node2.value != node1.value) {
                result = false;
                break;
            }
            node2 = node2.next;
            node1 = node1.next;
        }
        // 恢复原链
        node1 = node3.next;
        node3.next = null;
        while (node1 != null) {
            node2 = node1.next;
            node1.next = node3;
            node3 = node1;
            node1 = node2;
        }
        return result;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
//        head.next.next.next.next.next.next.next.next = new Node(1);

        System.out.println(isPalindrome1(head));
        System.out.println(isPalindrome2(head));
        System.out.println(isPalindrome3(head));
    }
}
