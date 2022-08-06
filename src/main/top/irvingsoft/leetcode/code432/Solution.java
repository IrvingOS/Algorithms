package top.irvingsoft.leetcode.code432;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {

    private Node head;
    private Map<String, Node> keyMap;
    private Node tail;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        keyMap = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public void dec(String key) {
        Node node = keyMap.get(key);
        node.set.remove(key);
        int count = node.count;
        if (count - 1 == 0) {
            keyMap.remove(key);
            clear(node);
            return;
        }
        if (node.prev.count == count - 1) {
            node.prev.set.add(key);
            keyMap.put(key, node.prev);
        } else {
            Node newNode = new Node(count - 1);
            newNode.set.add(key);
            newNode.next = node;
            newNode.prev = node.prev;
            node.prev.next = newNode;
            node.prev = newNode;
            keyMap.put(key, newNode);
        }
        clear(node);
    }

    public String getMaxKey() {
        Node node = tail.prev;
        for (String str : node.set) {
            return str;
        }
        return "";
    }

    public String getMinKey() {
        Node node = head.next;
        for (String str : node.set) {
            return str;
        }
        return "";
    }

    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.set.remove(key);
            int count = node.count;
            if (node.next.count == count + 1) {
                node.next.set.add(key);
                keyMap.put(key, node.next);
            } else {
                Node newNode = new Node(count + 1);
                newNode.set.add(key);
                newNode.next = node.next;
                newNode.prev = node;
                node.next.prev = newNode;
                node.next = newNode;
                keyMap.put(key, newNode);
            }
            clear(node);
        } else {
            if (head.next.count == 1) {
                head.next.set.add(key);
                keyMap.put(key, head.next);
            } else {
                Node newNode = new Node(1);
                newNode.set.add(key);
                newNode.next = head.next;
                newNode.prev = head;
                head.next.prev = newNode;
                head.next = newNode;
                keyMap.put(key, newNode);
            }
        }
    }

    private void clear(Node node) {
        if (node.set.size() == 0) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    class Node {

        int count;
        Node next;
        Node prev;
        Set<String> set;

        public Node(int count) {
            this.count = count;
            set = new HashSet<>();
        }

    }

}

/**
 * 全 O(1) 的数据结构
 *
 * @author TimeChaser
 * @since 2022/3/16 9:56 AM
 */
public class Solution {

}