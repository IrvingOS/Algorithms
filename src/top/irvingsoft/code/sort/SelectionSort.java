package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 时间复杂度：O(n^2)
 *
 * @author TimeChaser
 * @date 2021/10/14 11:43
 */
public class SelectionSort {

    public static void swap(int[] arr, int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                min = arr[min] < arr[j] ? min : j;
            }

            if (i != min) {
                swap(arr, i, min);
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
