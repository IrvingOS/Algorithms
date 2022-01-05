package top.irvingsoft.algs4.fundamentals.analysisofalgorithms;

import top.irvingsoft.algs4.fundamentals.programmingmodel.BinarySearch;

import java.util.Arrays;

/**
 * 给定一个数组，找出两个元素和为 0 的元素对的个数
 * <p>
 * 二分查找算法不能处理重复元素
 *
 * @author TimeChaser
 * @since 2022/1/5 10:25
 */
public class TwoSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (BinarySearch.indexOf(a, -a[i]) > i) {
                count++;
            }
        }
        return count;
    }

    public static int countSorted(int[] a) {
        int n = a.length;
        int i = 0, j = n - 1;
        int count = 0;
        while (i < j) {
            int sum = a[i] + a[j];
            if (sum < 0) {
                i++;
            } else if (sum > 0) {
                j--;
            } else {
                int loCount = 1;
                int hiCount = 1;
                while (i + 1 < j && a[i] == a[i + 1]) {
                    loCount++;
                    i++;
                }
                while (i < j - 1 && a[j] == a[j - 1]) {
                    hiCount++;
                    j--;
                }
                count += loCount * hiCount;
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{-9, -9, -8, -8, -7, -6, -5, -5, -3, -3, -1, 0, 0, 1, 3, 3, 3, 4, 7, 7}));
        System.out.println(countSorted(new int[]{-9, -9, -8, -8, -7, -6, -5, -5, -3, -3, -1, 0, 0, 1, 3, 3, 3, 4, 7, 7}));
    }
}
