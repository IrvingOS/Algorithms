package top.irvingsoft.leetcode.code707;

/*
 * 设计链表
 */
public class Solution {

}


class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        head = new ListNode(0, null, null);
        tail = new ListNode(0, null, null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = null;
        if (index < size / 2) {
            cur = locateFromHead(index);
        } else {
            cur = locateFromTail(index);
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = index < 0 ? 0 : index;
        ListNode next = null;
        ListNode prev = null;
        if (index < size / 2) {
            next = locateFromHead(index);
        } else {
            next = locateFromTail(index);
        }
        prev = next.prev;
        ListNode newNode = new ListNode(val, prev, next);
        prev.next = newNode;
        next.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode toDelete = null;
        if (index < size / 2) {
            toDelete = locateFromHead(index);
        } else {
            toDelete = locateFromTail(index);
        }
        toDelete.prev.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;
        size--;
    }

    private ListNode locateFromHead(int index) {
        int step = index + 1;
        ListNode cur = head;
        while (--step >= 0) {
            cur = cur.next;
        }
        return cur;
    }

    private ListNode locateFromTail(int index) {
        int step = size - index;
        ListNode cur = tail;
        while (--step >= 0) {
            cur = cur.prev;
        }
        return cur;
    }
}

class ListNode {

    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}