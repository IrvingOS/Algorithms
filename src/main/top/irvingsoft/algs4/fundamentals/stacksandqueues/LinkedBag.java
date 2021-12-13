package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链式背包
 *
 * @author TimeChaser
 * @since 2021/12/13 21:41
 */
public class LinkedBag<Item> implements Iterable<Item> {

    private Node first;
    private int  n;

    public LinkedBag() {
        n = 0;
        first = null;
    }

    public void add(Item item) {
        n++;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class Node {
        private Item item;
        private Node next;
    }

    private class LinkedIterator implements Iterator<Item> {

        private Node cur;

        public LinkedIterator() {
            cur = first;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Stack underflow");
            }
            Item value = cur.item;
            cur = cur.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
