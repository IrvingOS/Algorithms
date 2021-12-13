package top.irvingsoft.algs4.sorting.priorityqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 最小堆索引优先队列
 *
 * @author TimeChaser
 * @since 2021/11/30 20:42
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {

    /**
     * 实现最小堆的数据结构，其中 pq[1] 指示了最小 Key 在 keys 中的下标
     */
    private final int[] pq;
    /**
     * 指示索引在最小堆中的下标，其下标与索引对应
     */
    private final int[] qp;
    /**
     * 保存所有的 Key，非最小堆结构，其下标与索引对应
     */
    private final Key[] keys;
    private final int   maxN;
    private       int   n;

    public IndexMinPQ(int maxN) {
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
        validateIndex(k);
        return qp[k] != -1;
    }

    public void decreaseKey(int k, Key key) {
        validateIndex(k);
        if (!contains(k)) {
            throw new NoSuchElementException("index is not in the priority queue");
        }
        if (key.compareTo(keys[k]) == 0) {
            throw new IllegalArgumentException("Calling decreaseKey() with a key equal to the key in the priority queue");
        }
        if (key.compareTo(keys[k]) > 0) {
            throw new IllegalArgumentException("Calling decreaseKey() with a key strictly greater than the key in the priority queue");
        }
        keys[k] = key;
        swim(qp[k]);
    }

    public int delMin() {
        if (size() == 0) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        int indexOfMin = pq[1];
        exchange(1, n--);
        sink(1);
        assert indexOfMin == pq[n + 1];
        pq[n + 1] = -1;
        keys[indexOfMin] = null;
        qp[indexOfMin] = -1;
        return indexOfMin;
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
            throw new IllegalArgumentException("Calling increaseKey() with a key equal to the key in the priority queue");
        }
        if (key.compareTo(keys[k]) < 0) {
            throw new IllegalArgumentException("Calling increaseKey() with a key strictly less than the key in the priority queue");
        }
        keys[k] = key;
        sink(qp[k]);
    }

    public void insert(int k, Key key) {
        validateIndex(k);
        if (contains(k)) {
            throw new IllegalArgumentException("index is already in the priority queue");
        }
        n++;
        qp[k] = n;
        pq[n] = k;
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

    public int minIndex() {
        if (n == 0) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }

    public Key minKey() {
        if (n == 0) {
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
        // 还要更新 qp
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void sink(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
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

        private final IndexMinPQ<Key> copy;

        public HeapIterator() {
            copy = new IndexMinPQ<>(maxN);
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
