package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * <p>
 * 不稳定
 * <p>
 * 时间复杂度：O(n log n)
 *
 * @author TimeChaser
 * @since 2021/10/23 11:54
 */
public class ShellSort implements IArraySort {

    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println(Arrays.toString(new ShellSort().sort(arr)));
    }

    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
        return arr;
    }

}
