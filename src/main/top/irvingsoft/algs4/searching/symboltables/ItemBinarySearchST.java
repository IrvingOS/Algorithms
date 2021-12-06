package top.irvingsoft.algs4.searching.symboltables;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author TimeChaser
 * @since 2021/11/29 18:20
 */
public class ItemBinarySearchST<Key extends Comparable<Key>, Value> {

    private final int                capacity;
    private       Item<Key, Value>[] items;
    private       int                n;

    public ItemBinarySearchST() {
        this(8);
    }

    public ItemBinarySearchST(Item<Key, Value>[] items) {
        this.n = items.length;
        this.items = mergeSort(items);
        this.capacity = this.items.length;
    }

    public ItemBinarySearchST(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity to BinarySearchST() is negative number");
        }
        items = new Item[capacity];
        this.capacity = capacity;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to contains() is null");
        }
        return get(key) != null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to delete() is null");
        }
        int i = rank(key);
        if (i < n && key.compareTo(items[i].key) == 0) {
            if (n - 1 - i >= 0) {
                System.arraycopy(items, i + 1, items, i, n - 1 - i);
            }
            n--;
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to get() is null");
        }
        int i = rank(key);
        if (i < n && key.compareTo(items[i].key) == 0) {
            return items[i].value;
        }
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        if (n == 0) {
            return null;
        }
        return rangeSearch(min(), max());
    }

    public Key max() {
        return n != 0 ? items[n - 1].key : null;
    }

    public Key min() {
        return n != 0 ? items[0].key : null;
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
        if (i < n && key.compareTo(items[i].key) == 0) {
            items[i].value = value;
            return;
        }
        if (n == items.length) {
            resize();
        }
        if (n - i >= 0) {
            System.arraycopy(items, i, items, i + 1, n - i);
        }
        items[i] = new Item(key, value);
        n++;
    }

    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to rank() is null");
        }
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(items[mid].key);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public int size() {
        return n;
    }

    private Item<Key, Value>[] merge(Item<Key, Value>[] leftSub, Item<Key, Value>[] rightSub) {
        Item<Key, Value>[] items = new Item[leftSub.length + rightSub.length];
        int left = 0;
        int right = 0;
        int i = 0;
        while (left < leftSub.length && right < rightSub.length) {
            if (leftSub[left].key.compareTo(rightSub[right].key) < 0) {
                items[i++] = leftSub[left];
                left++;
            } else {
                items[i++] = rightSub[right];
                right++;
            }
        }
        return items;
    }

    private Item<Key, Value>[] mergeSort(Item<Key, Value>[] items) {
        if (items.length < 2) {
            return items;
        }
        int mid = items.length / 2;
        Item<Key, Value>[] leftSub = mergeSort(sub(items, 0, mid));
        Item<Key, Value>[] rightSub = mergeSort(sub(items, mid, items.length));
        return merge(leftSub, rightSub);
    }

    private Iterable<Key> rangeSearch(Key lo, Key hi) {
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
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.offer(items[i].key);
        }
        if (contains(hi)) {
            queue.offer(items[rank(hi)].key);
        }
        return queue;
    }

    private void resize() {
        Item<Key, Value>[] tempItems = (Item<Key, Value>[]) new Comparable[n + capacity];
        for (int i = 0; i < n; i++) {
            tempItems[i] = items[i];
        }
        items = tempItems;
    }

    private Item<Key, Value>[] sub(Item<Key, Value>[] items, int from, int to) {
        Item<Key, Value>[] sub = (Item<Key, Value>[]) new Comparable[to - from];
        for (int i = from; i < to; i++) {
            sub[i - from] = items[i];
        }
        return sub;
    }

    /**
     * <s>private class Item implements Comparable<Item></s>
     * <p>
     * 不这样写的原因是，最终的操作比较的是 key 之间的 compareTo，而不是 item
     */
    private static class Item<Key, Value> {
        private final Key   key;
        private       Value value;

        public Item(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
