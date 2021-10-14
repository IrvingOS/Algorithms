package top.irvingsoft.test.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[min] < arr[j] ? min : j;
            }
            if (i != min) {
                arr[min] ^= arr[i];
                arr[i] ^= arr[min];
                arr[min] ^= arr[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
