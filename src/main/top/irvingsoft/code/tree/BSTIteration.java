package top.irvingsoft.code.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Search Tree
 * <p>
 * All operation are implemented by iteration.
 *
 * @author TimeChaser
 * @since 2021/11/27 17:44
 */
public class BSTIteration<Key extends Comparable<Key>, Value> {

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    public Value get(Key key) {
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
                return cur.val;
            } else if (compareTo < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        boolean contains = get(key) != null;
        Node cur = x;
        while (true) {
            if (!contains) {
                cur.n++;
            }
            int compareTo = key.compareTo(cur.key);
            if (compareTo == 0) {
                cur.val = val;
                break;
            } else if (compareTo < 0) {
                if (cur.left == null) {
                    cur.left = new Node(key, val, 1);
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Node(key, val, 1);
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
        return floor(root, key);
    }

    private Key floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        Node cur = x;
        Node temp = null;
        while (cur != null) {
            int compareTo = key.compareTo(cur.key);
            if (compareTo == 0) {
                return cur.key;
            } else if (compareTo < 0) {
                cur = cur.left;
            } else {
                temp = cur;
                cur = cur.right;
            }
        }
        return temp != null ? temp.key : null;
    }

    public Key ceiling(Key key) {
        return ceiling(root, key);
    }

    private Key ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        Node cur = x;
        Node pre = null;
        while (cur != null) {
            int compareTo = key.compareTo(cur.key);
            if (compareTo == 0) {
                return cur.key;
            } else if (compareTo < 0) {
                pre = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return pre != null ? pre.key : null;
    }

    public Key select(int k) {
        return select(root, k);
    }

    private Key select(Node x, int k) {
        if (x == null) {
            return null;
        }
        Node cur = x;
        while (cur != null) {
            int t = size(cur.left);
            if (k == t) {
                return cur.key;
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
        root = deleteMin(root);
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
        root = deleteMax(root);
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
        root = delete(root, key);
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
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
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
