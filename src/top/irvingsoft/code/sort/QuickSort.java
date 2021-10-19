package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * 快速排序
 * <p>
 * 时间复杂度：O(n log n)
 * <p>
 * 思想：
 * <p>
 * 分治法，每次以随机一个数为基准，对这个基准进行相对排序。
 * 然后在这个基准两边重复这个流程。
 *
 * @author TimeChaser
 * @date 2021/10/13 12:03
 */
public class QuickSort implements IArraySort {

    public static void main(String[] args) {

        int[] arr = {11, 91, 41, 10, 36, 14, 82, 8, 4, 5};
        System.out.println(Arrays.toString(new InsertSort().sort(arr)));
    }

    @Override
    public int[] sort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(arr, 0, arr.length - 1);
    }

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

    public static int[] quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = getMid(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
        return arr;
    }
}
