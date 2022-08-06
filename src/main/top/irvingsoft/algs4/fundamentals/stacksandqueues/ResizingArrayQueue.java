package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 动态数组队列
 *
 * @author TimeChaser
 * @since 2021/12/13 20:22
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {

    private static final int INIT_CAPACITY = 8;

    private Item[] a;
    private int first;
    private int last;
    private int n;

    public ResizingArrayQueue() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item value = a[first++];
        a[first - 1] = null;
        if (first == a.length) {
            first = 0;
        }
        n--;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return value;
    }

    public void enqueue(Item item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[last++] = item;
        if (last == a.length) {
            last = 0;
        }
        n++;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return a[first];
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

        private int i;

        public ArrayIterator() {
            i = 0;
        }

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Queue underflow");
            }
            return a[(first + i++) % a.length];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
