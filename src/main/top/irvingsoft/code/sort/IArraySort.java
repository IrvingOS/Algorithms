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
     * @param i   index1
     * @param j   index2
     */
    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
