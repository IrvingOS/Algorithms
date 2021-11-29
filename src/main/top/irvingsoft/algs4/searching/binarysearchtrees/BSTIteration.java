package top.irvingsoft.algs4.searching.binarysearchtrees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Search Tree
 * <p>
 * All operation are implemented by iteration.
 * <p>
 * Key != null && Value != null
 *
 * @author TimeChaser
 * @since 2021/11/27 17:44
 */
public class BSTIteration<Key extends Comparable<Key>, Value> {

    private Node root;

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to contains() is null");
        }
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to get() is null");
        }
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        Node cur = x;
        while (cur != null) {
            int compareTo = key.compareTo(cur.key);
            if (compareTo == 0) {
                return cur.value;
            } else if (compareTo < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
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
        } else {
            root = put(root, key, value);
        }
        assert check();
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        boolean contains = get(key) != null;
        Node cur = x;
        while (true) {
            if (!contains) {
                cur.n++;
            }
            int compareTo = key.compareTo(cur.key);
            if (compareTo == 0) {
                cur.value = value;
                break;
            } else if (compareTo < 0) {
                if (cur.left == null) {
                    cur.left = new Node(key, value, 1);
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Node(key, value, 1);
                    break;
                }
                cur = cur.right;
            }
        }
        return x;
    }

    public Key min() {
        Node node = min(root);
        return node != null ? node.key : null;
    }

    private Node min(Node x) {
        if (x == null) {
            return null;
        }
        Node cur = x;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public Key max() {
        Node node = max(root);
        return node != null ? node.key : null;
    }

    private Node max(Node x) {
        if (x == null) {
            return null;
        }
        Node cur = x;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to floor() is null");
        }
        Node x = floor(root, key);
        return x != null ? x.key : null;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        Node cur = x;
        Node temp = null;
        while (cur != null) {
            int compareTo = key.compareTo(cur.key);
            if (compareTo == 0) {
                return cur;
            } else if (compareTo < 0) {
                cur = cur.left;
            } else {
                temp = cur;
                cur = cur.right;
            }
        }
        return temp;
    }

    public Key ceiling(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to ceiling() is null");
        }
        Node x = ceiling(root, key);
        return x != null ? x.key : null;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        Node cur = x;
        Node pre = null;
        while (cur != null) {
            int compareTo = key.compareTo(cur.key);
            if (compareTo == 0) {
                return cur;
            } else if (compareTo < 0) {
                pre = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return pre;
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("k to select() is illegal");
        }
        Node x = select(root, k);
        return x != null ? x.key : null;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        Node cur = x;
        while (cur != null) {
            int t = size(cur.left);
            if (k == t) {
                return cur;
            } else if (k < t) {
                cur = cur.left;
            } else {
                k = k - t - 1;
                cur = cur.right;
            }
        }
        return null;
    }

    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to rank() is null");
        }
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        Node cur = x;
        int r = 0;
        while (cur != null) {
            int compareTo = key.compareTo(cur.key);
            if (compareTo == 0) {
                return r + size(cur.left);
            } else if (compareTo < 0) {
                cur = cur.left;
            } else {
                r += 1 + size(cur.left);
                cur = cur.right;
            }
        }
        return r;
    }

    public void deleteMin() {
        if (root == null) {
            return;
        }
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        Node cur = x;
        while (cur != null && cur.left != null) {
            cur.n--;
            if (cur.left.left == null) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        return x;
    }

    public void deleteMax() {
        if (root == null) {
            return;
        }
        root = deleteMax(root);
        assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        Node cur = x;
        while (cur != null && cur.right != null) {
            cur.n--;
            if (cur.right.right == null) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return x;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to delete() is null");
        }
        root = delete(root, key);
        assert check();
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        Node dummy = new Node();
        dummy.left = x;
        Node cur = dummy.left;
        Node pre = dummy;
        boolean left = true;
        while (cur != null) {
            cur.n--;
            int compareTo = key.compareTo(cur.key);
            if (compareTo == 0) {
                if (cur.left == null) {
                    cur = cur.right;
                } else if (cur.right == null) {
                    cur = cur.left;
                } else {
                    Node t = cur;
                    cur = min(t.right);
                    cur.right = deleteMin(t.right);
                    cur.left = max(t.left);
                    cur.n = 1 + size(cur.left) + size(cur.right);
                }
                if (left) {
                    pre.left = cur;
                } else {
                    pre.right = cur;
                }
                break;
            } else if (compareTo < 0) {
                pre = cur;
                left = true;
                cur = cur.left;
            } else {
                pre = cur;
                left = false;
                cur = cur.right;
            }
        }
        return dummy.left;
    }

    public Iterable<Key> keys() {
        return rangeSearch(min(), max());
    }

    public Iterable<Key> rangeSearch(Key lo, Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException("lo to rangeSearch() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException("hi to rangeSearch() is null");
        }
        if (lo.compareTo(hi) > 0) {
            return null;
        }
        Queue<Key> queue = new ArrayDeque<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = x;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                int cmpLo = lo.compareTo(cur.key);
                int cmpHi = hi.compareTo(cur.key);
                if (cmpHi >= 0) {
                    stack.push(cur);
                }
                if (cmpLo < 0) {
                    cur = cur.left;
                } else {
                    cur = null;
                }
            } else {
                cur = stack.pop();
                int cmpLo = lo.compareTo(cur.key);
                int cmpHi = hi.compareTo(cur.key);
                if (cmpLo <= 0 && cmpHi >= 0) {
                    queue.add(cur.key);
                }
                cur = cur.right;
            }
        }
    }

    private boolean check() {
        boolean BST = isBST();
        boolean sizeConsistent = isSizeConsistent();
        boolean rankConsistent = isRankConsistent();
        if (!BST) {
            System.out.println("Not in symmetric order");
        }
        if (!sizeConsistent) {
            System.out.println("Subtree counts not consistent");
        }
        if (!rankConsistent) {
            System.out.println("Ranks not consistent");
        }
        return BST && sizeConsistent && rankConsistent;
    }

    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (Key key : keys()) {
            if (key.compareTo(select(rank(key))) != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }

    private boolean isSizeConsistent(Node x) {
        if (x == null) {
            return true;
        }
        Node cur = x;
        Stack<Node> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.n != size(cur.left) + size(cur.right) + 1) {
                return false;
            }
            cur = cur.right;
        }
        return true;
    }

    private boolean isBST() {
        return isBST(root);
    }

    // TODO better isBST 的非递归实现
    private boolean isBST(Node x) {
        Queue<Key> keys = new LinkedList<>();
        keys(x, keys, min(x).key, max(x).key);
        Key lo = keys.poll();
        while (lo != null && !keys.isEmpty()) {
            Key cur = keys.poll();
            if (lo.compareTo(cur) >= 0) {
                return false;
            }
            lo = cur;
        }
        return true;
    }

    private class Node {
        private Key   key;
        private Value value;
        private Node  left, right;
        private int n;

        public Node() {
        }

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }
}
