package top.irvingsoft.test.sort;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @date 2021/10/13 15:16
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {11, 91, 41, 10, 36, 14, 82, 8, 4, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
