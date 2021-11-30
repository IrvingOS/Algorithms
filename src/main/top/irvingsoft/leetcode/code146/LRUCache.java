package top.irvingsoft.leetcode.code146;

import java.util.HashMap;
import java.util.Map;

/**
 * 双向链表 + 哈希表 实现 LRU 缓存
 * <p>
 * 双向链表保证缓存失效顺序，哈希表保证缓存存取速度
 *
 * @author TimeChaser
 * @since 2021/11/14 16:46
 */
public class LRUCache {

    private final int                       capacity;
    private final Map<Integer, DLinkedNode> cache;
    private final DLinkedNode               head;
    private final DLinkedNode               tail;
    private       int                       size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            addToHead(node);
            cache.put(key, node);
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = this.tail.prev;
        removeNode(node);
        return node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public class DLinkedNode {
        int         key;
        int         value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

