package top.irvingsoft.algs4.sorting.priorityqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 最大堆索引优先队列
 *
 * @author TimeChaser
 * @since 2021/12/6 18:24
 */
public class IndexMaxPQ<Key extends Comparable<Key>> implements Iterable<Integer> {

    private final Key[] keys;
    private final int maxN;
    private final int[] pq;
    private final int[] qp;
    private int n;

    public IndexMaxPQ(int maxN) {
        if (maxN < 0) {
            throw new IllegalArgumentException();
        }
        this.maxN = maxN;
        n = 0;
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        keys = (Key[]) new Comparable[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    public void changeKey(int k, Key key) {
        validateIndex(k);
        if (!contains(k)) {
            throw new NoSuchElementException("index is not in the priority queue");
        }
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void decreaseKey(int k, Key key) {
        validateIndex(k);
        if (!contains(k)) {
            throw new NoSuchElementException("index is not in the priority queue");
        }
        if (key.compareTo(keys[k]) == 0) {
            throw new IllegalArgumentException(
                    "Calling decreaseKey() with a key equal to the key in the priority queue");
        }
        if (key.compareTo(keys[k]) > 0) {
            throw new IllegalArgumentException(
                    "Calling decreaseKey() with a key strictly greater than the key in the priority queue");
        }
        keys[k] = key;
        sink(qp[k]);
    }

    public int delMax() {
        if (size() == 0) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        int indexOfMax = pq[1];
        exchange(1, n--);
        sink(1);
        assert indexOfMax == pq[n + 1];
        pq[n + 1] = -1;
        keys[indexOfMax] = null;
        qp[indexOfMax] = -1;
        return indexOfMax;
    }

    public void delete(int k) {
        validateIndex(k);
        if (!contains(k)) {
            throw new NoSuchElementException("index is not in the priority queue");
        }
        int index = qp[k];
        exchange(index, n--);
        swim(index);
        sink(index);
        pq[n + 1] = -1;
        keys[k] = null;
        qp[k] = -1;
    }

    public void increaseKey(int k, Key key) {
        validateIndex(k);
        if (!contains(k)) {
            throw new NoSuchElementException("index is not in the priority queue");
        }
        if (key.compareTo(keys[k]) == 0) {
            throw new IllegalArgumentException(
                    "Calling increaseKey() with a key equal to the key in the priority queue");
        }
        if (key.compareTo(keys[k]) < 0) {
            throw new IllegalArgumentException(
                    "Calling increaseKey() with a key strictly less than the key in the priority queue");
        }
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void insert(int k, Key key) {
        validateIndex(k);
        if (contains(k)) {
            throw new IllegalArgumentException("index is already in the priority queue");
        }
        n++;
        pq[n] = k;
        qp[k] = n;
        keys[k] = key;
        swim(n);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Key keyOf(int k) {
        validateIndex(k);
        if (!contains(k)) {
            throw new NoSuchElementException("index is not in the priority queue");
        }
        return keys[k];
    }

    public int maxIndex() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }

    public Key maxKey() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return keys[pq[1]];
    }

    public int size() {
        return n;
    }

    private void exchange(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void sink(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(j + 1, j)) {
                j++;
            }
            if (!less(j, k)) {
                break;
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

    private void validateIndex(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index is negative: " + i);
        }
        if (i >= maxN) {
            throw new IllegalArgumentException("index >= capacity: " + i);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {

        private final IndexMaxPQ<Key> copy;

        public HeapIterator() {
            copy = new IndexMaxPQ<>(maxN);
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i], keys[pq[i]]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Integer next() {
            return copy.delMax();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
