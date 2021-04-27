package top.irvingsoft.leetcode.code25;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: K 个一组翻转链表
 * <p>
 * 1、暴力法：
 * 把链表提取成数组，对数组进行 K 个字符的翻转，然后构造链表返回
 * 2、模拟：
 * 遍历链表，每 K 个节点进行翻转
 * @author: TimeChaser
 * @date: 2021/4/20 12:31
 */
public class Solution {

    public static ListNode reverseKGroupList(ListNode head, int k) {

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
        head = new ListNode();
        ListNode tail = head;
        for (Integer integer : integerList) {
            tail.next = new ListNode(integer);
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

    public static ListNode reverseKGroupNode(ListNode head, int k) {

        ListNode start = head;
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            if (i == k) {
                ListNode nextNode = curr.next;
                curr.next = null;
                ListNode reverse = null;
                while (start != null) {
                    ListNode temp = start.next;
                    start.next = reverse;
                    reverse = start;
                    start = temp;
                }
                reverse.next = nextNode;
                start = reverse.next;

                i = 0;
            }
            curr = curr.next;
        }
        return head;
    }


}
