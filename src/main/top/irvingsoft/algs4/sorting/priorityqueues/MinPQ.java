package top.irvingsoft.algs4.sorting.priorityqueues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 最小堆优先队列
 *
 * @author TimeChaser
 * @since 2021/12/1 15:11
 */
public class MinPQ<Key> implements Iterable<Key> {

    private Comparator<Key> comparator;
    private int n;
    private Key[] pq;

    public MinPQ() {
        this(1);
    }

    public MinPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    public MinPQ(int initCapacity, Comparator<Key> comparator) {
        this(initCapacity);
        this.comparator = comparator;
    }

    public MinPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
    }

    public MinPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < keys.length; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMinHeap();
    }

    public Key delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Key min = pq[1];
        exchange(1, n--);
        pq[n + 1] = null;
        if (n > 0 && n == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        sink(1);
        assert isMinHeap();
        return min;
    }

    public void insert(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to insert() is null");
        }
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = key;
        swim(n);
        assert isMinHeap();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return pq[1];
    }

    public int size() {
        return n;
    }

    private void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean isMinHeap() {
        for (int i = 1; i <= n; i++) {
            if (pq[i] == null) {
                return false;
            }
        }
        for (int i = n + 1; i < pq.length; i++) {
            if (pq[i] != null) {
                return false;
            }
        }
        if (pq[0] != null) {
            return false;
        }
        return isMinHeapOrdered(1);
    }

    private boolean isMinHeapOrdered(int k) {
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (!less(k, left) || !less(k, right)) {
            return false;
        }
        return isMinHeapOrdered(left) && isMinHeapOrdered(right);
    }

    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    private void sink(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(j + 1, j)) {
                j++;
            }
            if (!less(j, k)) {
                return;
            }
            exchange(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exchange(k, k / 2);
            k /= 2;
        }
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        private final MinPQ<Key> copy;

        public HeapIterator() {
            if (comparator == null) {
                copy = new MinPQ<>(size());
            } else {
                copy = new MinPQ<>(size(), comparator);
            }
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
