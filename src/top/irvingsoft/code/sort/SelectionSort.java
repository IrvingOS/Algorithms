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
public class SelectionSort implements IArraySort {

    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println(Arrays.toString(new SelectionSort().sort(arr)));
    }

    @Override
    public int[] sort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[min] < arr[j] ? min : j;
            }
            if (i != min) {
                swap(arr, i, min);
            }
        }
        return arr;
    }
}
