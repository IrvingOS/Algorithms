package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.Iterator;

/**
 * 链表
 *
 * @author TimeChaser
 * @since 2021/12/14 10:53
 */
public class LinkedList<Item> implements Iterable<Item> {



    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class Node {
        private Item item;
        private Node next;
    }
}
