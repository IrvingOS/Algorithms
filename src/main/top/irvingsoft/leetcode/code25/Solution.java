package top.irvingsoft.leetcode.code25;

import top.irvingsoft.structure.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * K 个一组翻转链表
 * <p>
 * 1、暴力法：
 * 把链表提取成数组，对数组进行 K 个字符的翻转，然后构造链表返回
 * <p>
 * 2、模拟：
 * 遍历链表，每 K 个结点进行翻转
 *
 * @author TimeChaser
 * @since 2021/4/20 12:31
 */
public class Solution {

    public static Node reverseKGroupList(Node head, int k) {

        ArrayList<Integer> integerList = new ArrayList<>();

        while (head != null) {
            integerList.add(head.val);
            head = head.next;
        }

        int count = 1;
        while (count * k <= integerList.size()) {
            reverseList(integerList, (count - 1) * k, count * k - 1);
            count++;
        }
        head = new Node();
        Node tail = head;
        for (Integer integer : integerList) {
            tail.next = new Node(integer);
            tail = tail.next;
        }
        return head.next;
    }

    public static void reverseList(List<Integer> integerList, int start, int end) {

        int middle = (end - start) / 2 + start;
        for (int i = start; i <= middle; i++) {
            Integer integer = integerList.get(i);
            if ((end - start) % 2 == 0) {
                integerList.set(i, integerList.get(middle * 2 - i));
                integerList.set(middle * 2 - i, integer);
            } else {
                integerList.set(i, integerList.get(middle * 2 + 1 - i));
                integerList.set(middle * 2 + 1 - i, integer);
            }
        }
    }

    public static Node reverseKGroupNode(Node head, int k) {

        Node hair = new Node(0);
        hair.next = head;
        Node pre = hair;

        while (head != null) {

            Node tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            Node next = tail.next;
            reverseList(head, tail);
            // 翻转之后，head 即是尾结点，tail 即是头结点
            // 把前缀的 next 指向翻转后的头部
            pre.next = tail;
            // 把后缀拼接到翻转后的尾部
            head.next = next;
            // 把前缀指针移到已翻转部分的尾部
            pre = head;
            // 把 head 移到下次翻转部分的头部
            head = head.next;
        }

        return hair.next;
    }

    public static void reverseList(Node head, Node tail) {

        Node last = null, current = head;
        while (current != tail) {
            Node next = current.next;
            current.next = last;
            last = current;
            current = next;
        }
        tail.next = last;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node node = new Node(5);
        node.next = new Node(3);
        node.next.next = new Node(6);
        node.next.next.next = new Node(7);
        node.next.next.next.next = new Node(9);
        node.next.next.next.next.next = new Node(2);
        Node tail = node.next.next.next.next.next;
        print(reverseKGroupList(node, 2));
        System.out.println();
        print(reverseKGroupNode(node, 2));
    }
}
