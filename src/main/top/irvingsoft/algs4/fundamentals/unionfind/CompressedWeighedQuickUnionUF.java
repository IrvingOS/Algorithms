package top.irvingsoft.algs4.fundamentals.unionfind;

/**
 * 路径压缩的加权 Quick-Union 型 Union-Find
 *
 * @author TimeChaser
 * @since 2021/11/30 16:43
 */
public class CompressedWeighedQuickUnionUF {

    private final int[] id;
    private final int[] weight;
    private int count;

    public CompressedWeighedQuickUnionUF(int n) {
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

    /**
     * 在 find() 的过程中实现路径压缩
     */
    public int find(int p) {
        if (p == id[p]) {
            return p;
        }
        return id[p] = find(id[p]);
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
