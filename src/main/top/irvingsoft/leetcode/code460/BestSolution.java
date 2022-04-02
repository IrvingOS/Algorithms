package top.irvingsoft.leetcode.code460;

/**
 * @author TimeChaser
 * @since 2022/3/16 3:17 PM
 */
public class BestSolution {
}

class BestLFUCache {
    public int cap;
    public int size;
    public int minFreq;
    Node[] keyMap;
    Node[] freqMap;


    public BestLFUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.minFreq = 1;
        this.keyMap = new Node[100001];
        this.freqMap = new Node[20001];//存储频率

    }

    public int get(int key) {
        Node n = keyMap[key];
        if (n == null) {
            return -1;
        }
        update(key);//更新
        return n.value;//返回值
    }

    public void put(int key, int value) {
        Node n = keyMap[key];
        if (n == null) {
            if (cap == 0) {
                return;
            }
            ++size;
            if (size > cap) {
                Node head = freqMap[minFreq];//取得最小频率节点
                Node lfu = head.prev;
                lfu.remove();//删除频率最低的节点
                keyMap[lfu.key] = null;//设置为空
                if (head == head.next) {
                    freqMap[minFreq] = null;//清空
                }
                --size;//减小空间
            }
            n = new Node(key, value);//创建节点
            keyMap[key] = n;//保存节点
            if (freqMap[1] == null) {
                Node head = new Node();
                head.prev = head;
                head.next = head;
                freqMap[1] = head;//插入节点

            }
            n.add(freqMap[1]);//追加
            minFreq = 1;
        } else {
            n.value = value;
            update(key);//更新频率
        }
    }

    public void update(int key) {
        Node n = keyMap[key];
        n.remove();//删除
        int freq = n.freq;//取得频率
        if (freqMap[freq] == freqMap[freq].next) {
            freqMap[freq] = null;//设置为空
            if (freq == minFreq) {
                ++minFreq;//当下就是最小频率，频率更新
            }
        }
        freq = ++n.freq;//取得频率
        if (freqMap[freq] == null) {
            Node head = new Node();
            head.prev = head;
            head.next = head;
            freqMap[freq] = head;//插入节点
        }
        n.add(freqMap[freq]);//追加节点
    }

    public class Node {
        public int key;
        public int value;
        public int freq;
        public Node prev, next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

        public void remove() { // 将当前节点删除
            this.prev.next = next;
            this.next.prev = prev;
        }

        public void add(Node n) { // 将当前节点插入到 n 之后
            this.prev = n;
            this.next = n.next;
            n.next = this;
            this.next.prev = this;
        }
    }
}