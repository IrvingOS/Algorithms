package top.irvingsoft.chengyun.recursionandynamic;

/**
 * Page 199
 *
 * @author TimeChaser
 * @date 2021/9/25 15:06
 */
public class Fibonacci {

    public static int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1;
        int res = 1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] temp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1)!=0) {
                res = multiMatrix(res, temp);
            }
            temp = multiMatrix(temp, temp);
        }
        return res;
    }

    public static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
