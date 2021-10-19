package top.irvingsoft.test.sort;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @date 2021/10/13 14:31
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {

    }

    public static void main(String[] args) {

        int[] arr = {11, 91, 41, 10, 36, 14, 82, 8, 4, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
