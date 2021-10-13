package top.irvingsoft.test.sort;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @date 2021/10/13 14:31
 */
public class QuickSort {

    public static int getMid(int[] arr, int left, int right) {

        int pivot = arr[left];
        while (left < right) {
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = getMid(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    public static void main(String[] args) {

        int[] arr = {11, 91, 41, 10, 36, 14, 82, 8, 4, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
