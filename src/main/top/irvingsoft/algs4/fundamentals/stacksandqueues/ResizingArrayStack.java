package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 动态数组堆栈
 *
 * @author TimeChaser
 * @since 2021/12/13 19:19
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private static final int INIT_CAPACITY = 8;

    private Item[] a;
    private int n;

    public ResizingArrayStack() {
        n = 0;
        a = (Item[]) new Object[INIT_CAPACITY];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return a[n - 1];
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public void push(Item item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[n++] = item;
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
