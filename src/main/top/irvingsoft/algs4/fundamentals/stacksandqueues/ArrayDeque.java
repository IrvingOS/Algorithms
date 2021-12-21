package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 双端队列
 *
 * @author TimeChaser
 * @since 2021/12/20 14:30
 */
public class ArrayDeque<Item> implements Iterable<Item> {

    private static final int INIT_CAPACITY = 8;

    private Item[] a;
    private int    n;
    private int    first;
    private int    last;
    private int    modCount;

    public ArrayDeque() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
        modCount = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void offer(Item item) {
        offerLast(item);
    }

    public void offerFirst(Item item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        if (first == 0) {
            first = a.length - 1;
        } else {
            first--;
        }
        a[first] = item;
        n++;
        modCount++;
    }

    public void offerLast(Item item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[last++] = item;
        if (last == a.length) {
            last = 0;
        }
        n++;
        modCount++;
    }

    public Item poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return pollFirst();
    }

    public Item pollFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = a[first++];
        a[first - 1] = null;
        if (first == a.length) {
            first = 0;
        }
        n--;
        modCount++;
        return item;
    }

    public Item pollLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (last == 0) {
            last = a.length;
        }
        Item item = a[--last];
        a[last] = null;
        n--;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        modCount++;
        return item;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = a[(first + i) % a.length];
        }
        a = copy;
        first = 0;
        last = n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
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

    private class ArrayIterator implements Iterator<Item> {

        private final int exceptedModCount;
        private       int i;

        public ArrayIterator() {
            i = 0;
            exceptedModCount = modCount;
        }

        private void checkConcurrentModification() {
            if (exceptedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            checkConcurrentModification();
            return i < n;
        }

        @Override
        public Item next() {
            checkConcurrentModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return a[(first + i++) % a.length];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
