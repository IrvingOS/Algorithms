package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 稳定
 * <p>
 * 时间复杂度：O(n^2)
 *
 * @author TimeChaser
 * @since 2021/10/13 14:37
 */
public class BubbleSort implements IArraySort {

    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println(Arrays.toString(new BubbleSort().sort(arr)));
    }

    /**
     * i 表示冒泡的轮次，j 表示数组下标
     * <p>
     * 为什么只需要 arr.length - 1 轮？
     * <p>
     * 因为如果最小的数在最后的下标上，只需要 arr.length - 1 轮就能交换到 0 号下标
     *
     * @since 2021/10/13 14:48
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                return arr;
            }
        }
        return arr;
    }

}
