package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 时间复杂度：O(n log n)
 *
 * @author TimeChaser
 * @author TimeChaser
 * @date 2021/10/19 14:45
 */
public class MergeSort implements IArraySort {

    public static void main(String[] args) {

        int[] arr = {11, 91, 41, 10, 36, 14, 82, 8, 4, 5};

        System.out.println(Arrays.toString(new MergeSort().sort(arr)));

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 5)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 3, 6)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 5, arr.length)));
    }

    /**
     * 从最小的分段（left 和 right 长度都为 1）开始合并
     * <p>
     * 从最小分段的有序到最大分段的有序
     */
    @Override
    public int[] sort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    public int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }
}
