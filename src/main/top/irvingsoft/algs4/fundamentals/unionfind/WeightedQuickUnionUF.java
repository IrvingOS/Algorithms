package top.irvingsoft.algs4.fundamentals.unionfind;

/**
 * 加权 Quick-Union 型 Union-Find
 * <p>
 * 两个操作均为对数级别
 *
 * @author TimeChaser
 * @since 2021/11/30 16:23
 */
public class WeightedQuickUnionUF {

    private final int[] id;
    private final int[] weight;
    private       int   count;

    public WeightedQuickUnionUF(int n) {
        count = n;
        id = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            weight[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        if (weight[pId] <= weight[qId]) {
            id[pId] = qId;
            weight[qId] += weight[pId];
        } else {
            id[qId] = pId;
            weight[pId] += weight[qId];
        }
        count--;
    }
}
