package top.irvingsoft.algs4.fundamentals.unionfind;

/**
 * Quick-Find 型 Union-Find
 * <p>
 * union() 方法的操作数为平方级别
 *
 * @author TimeChaser
 * @since 2021/11/30 16:10
 */
public class QuickFindUF {

    private final int[] id;
    private int count;

    public QuickFindUF(int n) {
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
        return id[p];
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == qId) {
                id[i] = pId;
            }
        }
        count--;
    }

}
