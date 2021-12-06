package top.irvingsoft.algs4.sorting.priorityqueues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 最大堆优先队列
 * <p>
 * 基于二叉堆、完全二叉树的数组实现
 *
 * @author TimeChaser
 * @since 2021/11/30 18:18
 */
public class MaxPQ<Key> implements Iterable<Key> {

    private Key[]           pq;
    private int             n;
    private Comparator<Key> comparator;

    public MaxPQ() {
        this(1);
    }

    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
    }

    public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this(initCapacity);
        this.comparator = comparator;
    }

    public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < keys.length; i++) {
            pq[i + 1] = keys[i];
        }
        // 从倒数第二层最右结点处开始下沉
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMaxHeap();
    }

    public Key delMax() {
        if (isEmpty()) {
            return null;
        }
        Key max = pq[1];
        exchange(1, n--);
        pq[n + 1] = null;
        if (n > 0 && n == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        sink(1);
        assert isMaxHeap();
        return max;
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
        assert isMaxHeap();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
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

    private boolean isMaxHeap() {
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
        return isMaxHeapOrdered(1);
    }

    private boolean isMaxHeapOrdered(int k) {
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= n && less(k, left)) {
            return false;
        }
        if (right <= n && less(k, right)) {
            return false;
        }
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }

    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    private void sink(int k) {
        while (k * 2 <= n) {
            int j = 2 * k;
            // 在两个子结点中找到更大的一个与父结点比较并交换
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

    /**
     * 在 MaxPQ 调用 iterator() 方法时，将 MaxPQ 的数据复制一份
     * <p>
     * 通过对副本的操作来处理 iterator
     */
    private class HeapIterator implements Iterator<Key> {

        private final MaxPQ<Key> copy;

        public HeapIterator() {
            if (comparator == null) {
                copy = new MaxPQ<>(size());
            } else {
                copy = new MaxPQ<>(size(), comparator);
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
            return copy.delMax();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
