package top.irvingsoft.algs4.fundamentals.programmingmodel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.1 课后习题
 *
 * @author TimeChaser
 * @since 2021/12/7 20:54
 */
public class Homework {

    private static final Map<Long, Long> FIBONACCI_CACHE = new HashMap<>();

    public static long Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (!FIBONACCI_CACHE.containsKey(n)) {
            FIBONACCI_CACHE.put((long) n, Fibonacci(n - 1) + Fibonacci(n - 2));
        }
        return FIBONACCI_CACHE.get(n);
    }

    /**
     * 欧几里得算法求两个数的最大公约数
     *
     * @param p P
     * @param q Q
     * @return int
     */
    public static int euclid(int p, int q) {
        if (q == 0) {
            return p;
        }
        return euclid(q, p % q);
    }

    public static double harmonic(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static int[] histogram(int[] arr, int m) {
        int[] result = new int[m];
        for (int i : arr) {
            if (i < m) {
                result[i]++;
            }
        }
        return result;
    }

    /**
     * log2N = logN / log2
     */
    public static int lg(int n) {
        long sum = 1;
        int count = 0;
        while (true) {
            sum *= 2;
            if (sum > n) {
                break;
            }
            count++;
        }
        return count;
    }

    /**
     * 求 ln(N!)
     *
     * @param n N
     * @return double
     */
    public static double lnFactorial(int n) {
        return Math.log(factorial(n));
    }

    public static void main(String[] args) {
        System.out.println(Homework.toBinaryString(9));
        System.out.println(Homework.lg(9));
        System.out.println(Arrays.toString(Homework.histogram(new int[]{47, 15, 12, 19, 44, 16, 19, 46, 24, 14}, 48)));
        System.out.println(Homework.euclid(1111111, 1234567));
        System.out.println(Homework.sqrt(9));
        System.out.println(Homework.harmonic(9));
    }

    public static double sqrt(double n) {
        if (n < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = n;
        while (Math.abs(t - n / t) > err * t) {
            t = (n / t + t) / 2.0;
        }
        return t;
    }

    public static String toBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i /= 2) {
            sb.insert(0, i % 2);
        }
        return sb.toString();
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] transpose = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

    /**
     * 求 N!
     *
     * @param n N
     * @return double
     */
    private static double factorial(double n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
