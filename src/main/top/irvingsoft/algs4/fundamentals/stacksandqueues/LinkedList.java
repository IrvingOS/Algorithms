package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表
 *
 * @author TimeChaser
 * @since 2021/12/14 10:53
 */
public class LinkedList<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int        n;
    private int        modCount;

    public LinkedList() {
        first = null;
        last = null;
        n = 0;
        modCount = 0;
    }

    public void add(Item item) {
        linkLast(item);
    }

    public void addFirst(Item item) {
        linkFirst(item);
    }

    public void addLast(Item item) {
        linkLast(item);
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean remove(Item item) {
        if (item == null) {
            for (Node<Item> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<Item> x = first; x != null; x = x.next) {
                if (item.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public Item remove(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        checkElementIndex(k);
        return unlink(node(k));
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return unlinkFirst();
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return unlinkLast();
    }

    public void reverse() {
        Node<Item> newFirst = last;
        Node<Item> newLast = first;
        first = newFirst;
        last = newLast;
        Node<Item> prev = null;
        for (Node<Item> x = first; x != null; x = x.next) {
            x.next = x.prev;
            x.prev = prev;
            prev = x;
        }
    }

    public int size() {
        return n;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new NoSuchElementException();
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < n;
    }

    private void linkFirst(Item item) {
        n++;
        modCount++;
        Node<Item> newFirst = new Node<>();
        newFirst.item = item;
        if (isEmpty()) {
            first = newFirst;
            last = first;
        } else {
            newFirst.next = first;
            first.prev = newFirst;
            first = newFirst;
        }
    }

    private void linkLast(Item item) {
        n++;
        modCount++;
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            last.prev = oldLast;
            oldLast.next = last;
        }
    }

    private Node<Item> node(int index) {
        Node<Item> x;
        if (index < (n >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = n - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    private Item unlink(Node<Item> x) {
        n--;
        modCount++;
        Node<Item> prev = x.prev;
        Node<Item> next = x.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        Item item = x.item;
        x.item = null;
        return item;
    }

    private Item unlinkFirst() {
        n--;
        modCount++;
        Node<Item> oldFirst = first;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        Item item = oldFirst.item;
        oldFirst.next = null;
        oldFirst.item = null;
        return item;
    }

    private Item unlinkLast() {
        n--;
        modCount++;
        Node<Item> oldLast = last;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }
        Item item = oldLast.item;
        oldLast.prev = null;
        oldLast.item = null;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('[');
        for (Node<Item> x = first; x != null; x = x.next) {
            s.append(x.item).append(", ");
        }
        if (s.length() > 3) {
            s.deleteCharAt(s.length() - 1);
            s.deleteCharAt(s.length() - 1);
        }
        s.append(']');
        return s.toString();
    }

    private static class Node<Item> {
        private Item       item;
        private Node<Item> next;
        private Node<Item> prev;

        public Node() {
        }

        public Node(Node<Item> prev, Item item, Node<Item> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private class LinkedIterator implements Iterator<Item> {

        private final int        expectedModCount;
        private       Node<Item> cur;

        public LinkedIterator() {
            this.cur = first;
            this.expectedModCount = modCount;
        }

        private void checkConcurrentModification() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            checkConcurrentModification();
            return cur != null;
        }

        @Override
        public Item next() {
            checkConcurrentModification();
            Item item = cur.item;
            cur = cur.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
