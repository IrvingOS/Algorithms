package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链式队列
 *
 * @author TimeChaser
 * @since 2021/12/13 21:02
 */
public class LinkedQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int  n;

    public LinkedQueue() {
        first = null;
        last = null;
        n = 0;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        n--;
        Item value = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        assert check();
        return value;
    }

    public void enqueue(Item item) {
        n++;
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        assert check();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    public int size() {
        return n;
    }

    private boolean check() {
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            return first == null && last == null;
        } else if (n == 1) {
            return first != null && first.next == null && first == last;
        } else {
            if (first == null || first.next == null || last == null || last.next != null || first == last) {
                return false;
            }
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next) {
                numberOfNodes++;
            }
            if (numberOfNodes != n) {
                return false;
            }
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            return lastNode == last;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('[');
        for (Item item : this) {
            s.append(item);
            s.append(',').append(' ');
        }
        if (s.length() > 3) {
            s.deleteCharAt(s.length() - 1);
            s.deleteCharAt(s.length() - 1);
        }
        s.append(']');
        return s.toString();
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
