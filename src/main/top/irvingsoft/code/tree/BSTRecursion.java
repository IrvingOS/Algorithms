package top.irvingsoft.code.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Binary Search Tree
 * <p>
 * All operation are implemented using recursion.
 *
 * @author TimeChaser
 * @since 2021/11/18 15:19
 */
public class BSTRecursion<Key extends Comparable<Key>, Value> {

    private Node root;

    /**
     * 获取二叉查找树的大小
     *
     * @return int
     */
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    /**
     * 获取结点 key 的 value
     *
     * @param key 键
     * @return Value
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    /**
     * 新增或更新结点 key 的值
     *
     * @param key 结点 key
     * @param val 结点 value
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 获取最小的 key
     *
     * @return Key
     */
    public Key min() {
        if (root == null) {
            return null;
        }
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    /**
     * 获取最大的 key
     *
     * @return Key
     */
    public Key max() {
        if (root == null) {
            return null;
        }
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    /**
     * 获取 key 的向下取整 key
     *
     * @return Key
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        return x != null ? x.key : null;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        return t != null ? t : x;
    }

    /**
     * 获取 key 的向上取整 key
     *
     * @return Key
     */
    public Key ceiling(Key key) {
        Node t = ceiling(root, key);
        return t != null ? t.key : null;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp > 0) {
            return ceiling(x.right, key);
        }
        Node t = ceiling(x.left, key);
        return t != null ? t : x;
    }

    /**
     * 根据索引查找 key
     *
     * @param k 结点下标 [0, n)
     * @return Key
     */
    public Key select(int k) {
        Node x = select(root, k);
        return x != null ? x.key : null;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (k == t) {
            return x;
        } else if (k < t) {
            return select(x.left, k);
        } else {
            return select(x.right, k - t - 1);
        }
    }

    /**
     * 获取结点 key 的排名 [0, n)
     *
     * @param key 结点 key
     * @return int
     */
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return size(x.left);
        } else if (cmp < 0) {
            return rank(x.left, key);
        } else {
            return 1 + size(x.left) + rank(x.right, key);
        }
    }

    /**
     * 删除最小 key 的结点
     */
    public void deleteMin() {
        if (root == null) {
            return;
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除最大 key 的结点
     */
    public void deleteMax() {
        if (root == null) {
            return;
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除结点 key
     *
     * @param key 结点 key
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * T. Hibbard 提出：在删除结点 x 后用它的后继结点填补它的位置
     */
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            x.right = delete(x.right, key);
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 获取二叉查找树的 key 值迭代器
     *
     * @return java.lang.Iterable<Key>
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * 获取二叉查找树一定范围内的 key 值迭代器
     *
     * @param lo 迭代器起点
     * @param hi 迭代器终点
     * @return java.lang.Iterable<Key>
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new ArrayDeque<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int cmpLo = lo.compareTo(x.key);
        int cmpHi = hi.compareTo(x.key);
        if (cmpLo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmpLo <= 0 && cmpHi >= 0) {
            queue.add(x.key);
        }
        if (cmpHi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    private class Node {
        private Key   key;
        private Value val;
        private Node  left, right;
        private int n;

        public Node() {
        }

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }
}
