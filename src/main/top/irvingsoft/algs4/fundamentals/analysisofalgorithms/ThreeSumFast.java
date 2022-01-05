package top.irvingsoft.algs4.fundamentals.analysisofalgorithms;

import top.irvingsoft.algs4.fundamentals.programmingmodel.BinarySearch;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @since 2022/1/5 10:31
 */
public class ThreeSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countSorted(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    int loCount = 1;
                    int hiCount = 1;
                    while (j + 1 < k && a[j] == a[j + 1]) {
                        loCount++;
                        j++;
                    }
                    while (j < k - 1 && a[k] == a[k - 1]) {
                        hiCount++;
                        k--;
                    }
                    count += loCount * hiCount;
                    k--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 4, 6, -4, 0, -3, -3, 7, -4}));
        System.out.println(countSorted(new int[]{-9, -9, -8, -8, -7, -6, -5, -5, -3, -3, -1, 0, 0, 1, 3, 3, 3, 4, 7, 7}));
    }
}
