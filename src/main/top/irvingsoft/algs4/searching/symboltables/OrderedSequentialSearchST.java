package top.irvingsoft.algs4.searching.symboltables;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 有序顺序查找符号表
 * <p>
 * 基于有序链表
 *
 * @author TimeChaser
 * @since 2021/11/29 18:19
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {

    private Node first;
    private int n;

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to delete() is null");
        }
        Node dummy = new Node();
        dummy.next = first;
        for (Node x = dummy; x.next != null; x = x.next) {
            if (key.compareTo(x.next.key) == 0) {
                x.next = x.next.next;
                n--;
                return;
            }
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to get() is null");
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) == 0) {
                return x.value;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new ArrayDeque<>();
        for (Node x = first; x != null; x = x.next) {
            queue.offer(x.key);
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
        if (contains(key)) {
            for (Node x = first; x != null; x = x.next) {
                if (key.compareTo(x.key) == 0) {
                    x.value = value;
                    return;
                }
            }
        }
        /*int i = rank(key);
        Node dummy = new Node();
        dummy.next = first;
        Node x = dummy;
        while (i-- > 0) {
            x = x.next;
        }
        x.next = new Node(key, value, x.next);
        first = dummy.next;*/
        n++;
        Node dummy = new Node();
        dummy.next = first;
        Node x = dummy;
        for (; x.next != null; x = x.next) {
            if (key.compareTo(x.next.key) < 0) {
                x.next = new Node(key, value, x.next);
                first = dummy.next;
                return;
            }
        }
        x.next = new Node(key, value, null);
        first = dummy.next;
    }

    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to rank() is null");
        }
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) <= 0) {
                break;
            }
            i++;
        }
        return i;
    }

    private int size() {
        return n;
    }

    private class Node {

        private Key key;
        private Node next;
        private Value value;

        public Node() {
        }

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

}
