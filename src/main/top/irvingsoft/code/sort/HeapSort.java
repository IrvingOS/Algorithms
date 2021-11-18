package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @since 2021/11/15 15:25
 */
public class HeapSort implements IArraySort {

    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println(Arrays.toString(new HeapSort().sort(arr)));
    }

    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    public void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }
}
