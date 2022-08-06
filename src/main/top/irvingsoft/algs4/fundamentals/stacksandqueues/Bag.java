package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 背包
 *
 * @author TimeChaser
 * @since 2021/12/13 20:02
 */
public class Bag<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int n;

    public Bag() {
        n = 0;
        first = null;
    }

    public void add(Item item) {
        n++;
        Node<Item> oldFirst = first;
        first = new Node<>();
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

    private static class Node<Item> {

        private Item item;
        private Node<Item> next;

    }

    private class LinkedIterator implements Iterator<Item> {

        private Node<Item> cur;

        public LinkedIterator() {
            cur = first;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            if (isEmpty()) {
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
