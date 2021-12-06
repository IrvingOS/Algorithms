package top.irvingsoft.algs4.fundamentals.unionfind;

/**
 * Quick-Union 型 Union-Find
 * <p>
 * find() 方法的操作数为平方级别
 *
 * @author TimeChaser
 * @since 2021/11/30 16:15
 */
public class QuickUnionUF {

    private final int[] id;
    private       int   count;

    public QuickUnionUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
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
        id[qId] = pId;
        count--;
    }
}
