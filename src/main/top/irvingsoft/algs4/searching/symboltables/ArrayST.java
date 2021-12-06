package top.irvingsoft.algs4.searching.symboltables;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 顺序查找符号表
 * <p>
 * 基于无序数组
 *
 * @author TimeChaser
 * @since 2021/11/29 18:18
 */
public class ArrayST<Key extends Comparable<Key>, Value> {

    private final int     capacity;
    private       Key[]   keys;
    private       Value[] values;
    private       int     n;

    public ArrayST() {
        this(8);
    }

    public ArrayST(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity to BinarySearchST() is negative number");
        }
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(keys[i]);
        }
        return queue;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("key to put() is null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < n) {
            values[i] = value;
        } else {
            if (n == keys.length) {
                resize();
            }
            keys[n] = key;
            values[n] = value;
            n++;
        }
    }

    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to rank() is null");
        }
        for (int i = 0; i < n; i++) {
            if (key.compareTo(keys[i]) == 0) {
                return i;
            }
        }
        return n;
    }

    public int size() {
        return n;
    }

    private boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to contains() is null");
        }
        return get(key) != null;
    }

    private void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to delete() is null");
        }
        int i = rank(key);
        if (i < n) {
            for (int j = i; j < n - 1; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }
            n--;
        }
    }

    private Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to get() is null");
        }
        int i = rank(key);
        return i < n ? values[i] : null;
    }

    private void resize() {
        Key[] tempKeys = (Key[]) new Comparable[n + capacity];
        Value[] tempValues = (Value[]) new Object[n + capacity];
        for (int i = 0; i < n; i++) {
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }
        this.keys = tempKeys;
        this.values = tempValues;
    }
}
