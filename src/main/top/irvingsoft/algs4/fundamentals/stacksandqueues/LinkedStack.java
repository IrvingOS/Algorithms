package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链式堆栈
 *
 * @author TimeChaser
 * @since 2021/12/13 19:39
 */
public class LinkedStack<Item> implements Iterable<Item> {

    private Node first;
    private int  n;

    public LinkedStack() {
        n = 0;
        first = null;
        assert check();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        n--;
        Item value = first.item;
        first = first.next;
        assert check();
        return value;
    }

    public void push(Item item) {
        n++;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        assert check();
    }

    public int size() {
        return n;
    }

    private boolean check() {
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            return first == null;
        } else if (n == 1) {
            if (first == null) {
                return false;
            }
            return first.next == null;
        } else {
            if (first == null) {
                return false;
            }
            if (first.next == null) {
                return false;
            }
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next) {
                numberOfNodes++;
            }
            return numberOfNodes == n;
        }
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
