package top.irvingsoft.leetcode.code234;

import java.util.ArrayList;

/**
 * @description: 回文链表
 * @author: TimeChaser
 * @date: 2021/4/12 10:13
 */
public class Solution {

    private static ListNode frontPointer;

    /**
     * @description: 将链表转换成数组后用双指针（首尾指针）
     * @author: TimeChaser
     * @date: 2021/4/12 10:41
     */
    public static boolean isPalindromeToList(ListNode head) {

        ArrayList<Integer> valList = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            valList.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int front = 0, back = valList.size() - 1;
        while (front < back) {
            if (!valList.get(front).equals(valList.get(back))) {
                return false;
            }
            front++;
            back--;
        }

        return true;
    }

    /**
     * @description: 递归。用外部指针指向头部，直到递归到尾部时开始首尾比较
     * @author: TimeChaser
     * @date: 2021/4/12 10:42
     */
    public static boolean isPalindromeRecursion(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    public static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (frontPointer.val != currentNode.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    /**
     * @description: 快慢指针
     * <p>
     * 1. 找到前半部分链表的尾节点
     * 2. 反转后半部分链表
     * 3. 判断是否回文
     * 4. 恢复链表
     * 5. 返回结果
     * @author: TimeChaser
     * @date: 2021/4/12 10:44
     */
    public static boolean isPalindromeFastAndSlowPointer(ListNode head) {

        int length = 0;
        ListNode fastPointer = head, slowPointer = head;
        while (fastPointer != null) {
            length++;
            fastPointer = fastPointer.next;
        }



        return true;
    }

    public static void main(String[] args) {

    }
}
