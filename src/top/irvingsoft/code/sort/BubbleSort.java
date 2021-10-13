package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 时间复杂度：O(n^2)
 *
 * @author TimeChaser
 * @date 2021/10/13 14:37
 */
public class BubbleSort {

    public static void swap(int[] arr, int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

    /**
     * i 表示冒泡的轮次，j 表示数组下标
     * <p>
     * 为什么只需要 arr.length - 1 轮？
     * <p>
     * 因为如果最小的数在最后的下标上，只需要 arr.length - 1 轮就能交换到 0 号下标
     *
     * @author TimeChaser
     * @date 2021/10/13 14:48
     */
    public static void bubbleSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
