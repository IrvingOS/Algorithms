package top.irvingsoft.algs4.searching.symboltables;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 顺序查找符号表
 * <p>
 * 基于无序链表
 *
 * @author TimeChaser
 * @since 2021/11/29 15:08
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> {

    private Node first;

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to get() is null");
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("key to put() is null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to delete() is null");
        }
        if (first == null) {
            return;
        }
        if (key.equals(first.key)) {
            first = first.next;
            return;
        }
        for (Node pre = first, cur = pre.next; cur != null; pre = pre.next, cur = cur.next) {
            if (key.equals(cur.key)) {
                pre.next = cur.next;
                return;
            }
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        int size = 0;
        for (Node x = first; x != null; x = x.next) {
            size++;
        }
        return size;
    }

    public Key min() {
        if (first == null) {
            return null;
        }
        Key min = first.key;
        for (Node x = first; x != null; x = x.next) {
            if (min.compareTo(x.key) > 0) {
                min = x.key;
            }
        }
        return min;
    }

    public Key max() {
        if (first == null) {
            return null;
        }
        Key max = first.key;
        for (Node x = first; x != null; x = x.next) {
            if (max.compareTo(x.key) < 0) {
                max = x.key;
            }
        }
        return max;
    }

    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to floor() is null");
        }
        Key floor = null;
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) >= 0) {
                if (floor == null || floor.compareTo(x.key) < 0) {
                    floor = x.key;
                }
            }
        }
        return floor;
    }

    public Key ceiling(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to ceiling() is null");
        }
        Key ceiling = null;
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) <= 0) {
                if (ceiling == null || ceiling.compareTo(x.key) > 0) {
                    ceiling = x.key;
                }
            }
        }
        return ceiling;
    }

    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to rank() is null");
        }
        int rank = 0;
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) > 0) {
                rank++;
            }
        }
        return rank;
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("k to select() is illegal");
        }
        Queue<Key> queue = new PriorityQueue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.offer(x.key);
        }
        while (k-- > 0) {
            queue.poll();
        }
        return queue.poll();
    }

    public void deleteMin() {
        Key min = min();
        if (min != null) {
            delete(min);
        }
    }

    public void deleteMax() {
        Key max = max();
        if (max != null) {
            delete(max);
        }
    }

    public int size(Key lo, Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException("lo to rangeSearch() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException("hi to rangeSearch() is null");
        }
        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        int size = 0;
        for (Node x = first; x != null; x = x.next) {
            if (lo.compareTo(x.key) <= 0 && hi.compareTo(x.key) >= 0) {
                size++;
            }
        }
        return size;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException("lo to rangeSearch() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException("hi to rangeSearch() is null");
        }
        if (lo.compareTo(hi) > 0) {
            return null;
        }
        Deque<Key> keys = new ArrayDeque<>();
        for (Node x = first; x != null; x = x.next) {
            if (lo.compareTo(x.key) <= 0 && hi.compareTo(x.key) >= 0) {
                keys.offer(x.key);
            }
        }
        return keys;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private class Node {
        private final Key   key;
        private       Value value;
        private       Node  next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
