package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 时间复杂度：O(n^2)
 *
 * @author TimeChaser
 * @date 2021/10/14 15:05
 */
public class InsertSort {

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (i != j) {
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
