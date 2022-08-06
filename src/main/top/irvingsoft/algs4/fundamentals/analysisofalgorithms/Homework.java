package top.irvingsoft.algs4.fundamentals.analysisofalgorithms;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @since 2022/1/5 10:23
 */
public class Homework {

    public static double[] closestPair(double[] a) {
        if (a == null || a.length < 2) {
            return new double[0];
        }
        Arrays.sort(a);
        int n = a.length;
        double minSub = Double.MAX_VALUE;
        double num1 = 0.0, num2 = 0.0;
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(a[i] - a[i + 1]) < minSub) {
                minSub = Math.abs(a[i] - a[i + 1]);
                num1 = a[i];
                num2 = a[i + 1];
            }
        }
        return new double[]{num1, num2};
    }

    public static double[] furthestPair(double[] a) {
        if (a == null || a.length < 2) {
            return new double[0];
        }
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : a) {
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        return new double[]{min, max};
    }

    public static int localMinimumOfArray(int[] a) {
        if (a == null || a.length < 2) {
            return -1;
        }
        int n = a.length;
        if (a[0] < a[1]) {
            return a[0];
        }
        if (a[n - 2] > a[n - 1]) {
            return a[n - 1];
        }
        int lo = 1;
        int hi = n - 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < a[mid + 1] && a[mid] < a[mid - 1]) {
                return a[mid];
            } else if (a[mid - 1] < a[mid] && a[mid] < a[mid + 1]) {
                hi = mid - 1;
            } else if (a[mid - 1] > a[mid] && a[mid] > a[mid + 1]) {
                lo = mid + 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(localMinimumOfArray(new int[]{4, 2, 15, 6, 6, 6, 6}));
    }

}
