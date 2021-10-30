package top.irvingsoft.code.sort;

/**
 * @author TimeChaser
 * @since 2021/10/19 14:46
 */
public interface IArraySort {

    /**
     * 正序排序
     *
     * @param sourceArray 原数组
     * @return int[] 排序后的新数组
     */
    int[] sort(int[] sourceArray);

    /**
     * 数组交换
     *
     * @param arr Arrays
     * @param a   index1
     * @param b   index2
     */
    default void swap(int[] arr, int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }
}
