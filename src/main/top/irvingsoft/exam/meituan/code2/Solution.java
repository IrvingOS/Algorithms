package top.irvingsoft.exam.meituan.code2;

import java.util.Scanner;

/**
 * 小美的仓库整理
 *
 * @author TimeChaser
 * @since 2022/1/21 13:20
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = scan.nextInt() - 1;
        }
        UnionFind unionFind = new UnionFind(arr);
        boolean[] visited = new boolean[n];
        int[] result = new int[n];
        for (int i = n - 1; i > 0; i--) {
            int index = order[i];
            visited[index] = true;
            if (index - 1 >= 0 && visited[index - 1]) {
                unionFind.union(index, index - 1);
            }
            if (index + 1 < n && visited[index + 1]) {
                unionFind.union(index, index + 1);
            }
            result[i - 1] = Math.max(result[i], unionFind.getSum(index));
        }
        for (int i : result) {
            System.out.println(i);
        }
    }

    static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private final int[] sum;

        public UnionFind(int[] arr) {
            int n = arr.length;
            parent = new int[n];
            size = new int[n];
            sum = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
                sum[i] = 0;
            }
        }

        public int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        public int getSum(int a) {
            int rootA = find(a);
            return sum[rootA];
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false;
            }
            if (size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
                sum[rootA] += sum[rootB];
            } else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
                sum[rootB] += sum[rootA];
            }
            return true;
        }
    }
}
