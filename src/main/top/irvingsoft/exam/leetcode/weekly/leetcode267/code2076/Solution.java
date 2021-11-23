package top.irvingsoft.exam.leetcode.weekly.leetcode267.code2076;

/**
 * 处理含限制条件的好友请求
 *
 * @author TimeChaser
 * @since 2021/11/23 10:36
 */
public class Solution {

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        Union union = new Union(n);
        boolean[] result = new boolean[requests.length];
        int i = 0;
        for (int[] request : requests) {
            int[] arr = union.connect(request[0], request[1]);
            boolean canConnect = true;
            for (int[] restriction : restrictions) {
                if (union.isConnect(restriction[0], restriction[1])) {
                    canConnect = false;
                    break;
                }
            }
            if (!canConnect) {
                union.reset(arr);
            }
            result[i++] = canConnect;
        }
        return result;
    }

    static class Union {
        int[] parent;
        int[] size;

        Union(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int[] connect(int a, int b) {
            int rootA = root(a);
            int rootB = root(b);
            int sizeA = this.size[rootA];
            int sizeB = this.size[rootB];
            if (rootA == rootB) {
                return new int[]{rootA, rootB, sizeA, sizeB};
            }
            if (sizeA >= sizeB) {
                this.parent[rootB] = rootA;
                this.size[rootA]++;
            } else {
                this.parent[rootA] = rootB;
                this.size[rootB]++;
            }
            return new int[]{rootA, rootB, sizeA, sizeB};
        }

        public boolean isConnect(int a, int b) {
            return root(a) == root(b);
        }

        public void reset(int[] arr) {
            this.parent[arr[0]] = arr[0];
            this.parent[arr[1]] = arr[1];
            this.size[arr[0]] = arr[2];
            this.size[arr[1]] = arr[3];
        }

        private int root(int a) {
            while (a != parent[a]) {
                a = parent[a];
            }
            return a;
        }
    }
}
