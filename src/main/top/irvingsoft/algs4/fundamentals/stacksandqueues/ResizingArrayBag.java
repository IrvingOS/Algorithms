package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 动态数组背包
 *
 * @author TimeChaser
 * @since 2021/12/13 21:38
 */
public class ResizingArrayBag<Item> implements Iterable<Item> {

    private static final int INIT_CAPACITY = 8;

    private Item[] a;
    private int n;

    public ResizingArrayBag() {
        n = 0;
        a = (Item[]) new Object[INIT_CAPACITY];
    }

    public void add(Item item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[n++] = item;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(a, 0, copy, 0, n);
        a = copy;
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

        private int i;

        public ArrayIterator() {
            i = n - 1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return a[i--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}